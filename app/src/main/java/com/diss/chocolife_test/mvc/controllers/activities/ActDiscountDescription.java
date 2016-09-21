package com.diss.chocolife_test.mvc.controllers.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.balysv.materialmenu.MaterialMenuDrawable;
import com.diss.chocolife_test.R;
import com.diss.chocolife_test.mvc.controllers.adapters.AdapterVPImages;
import com.diss.chocolife_test.mvc.controllers.adapters.AdapterVPTextBlock;
import com.diss.chocolife_test.mvc.controllers.application.MainApplication;
import com.diss.chocolife_test.mvc.controllers.fragments.FRTextBlock;
import com.diss.chocolife_test.mvc.controllers.fragments.FRdiscountsList;
import com.diss.chocolife_test.mvc.models.TdiscountDesc;
import com.diss.chocolife_test.mvc.models.answers.TgeneralRequestAnswer;
import com.diss.chocolife_test.mvc.support.RestAdapter;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dmitry on 20.09.16.
 */

public class ActDiscountDescription extends AppCompatActivity {


    //region Dagger injections

    @Inject RestAdapter restAdapter;

    //endregion

    //region ButterKnife Views bindings

    @BindView(R.id.tbDescriptionScreen) Toolbar tbDescriptionScreen;
    @BindView(R.id.tlPagerTabsDiscount) TabLayout tlPagerTabsDiscount;
    @BindView(R.id.frTextContent) FrameLayout frTextContent;
    @BindView(R.id.vpDescriptionSlider) ViewPager vpDescriptionSlider;
    @BindView(R.id.ipIndicator) InkPageIndicator ipIndicator;
    @BindView(R.id.tvCellDiscountOldPrice) TextView tvCellDiscountOldPrice;
    @BindView(R.id.tvCellDiscountNewPrice) TextView tvCellDiscountNewPrice;
    @BindView(R.id.tvDiscountTitle) TextView tvDiscountTitle;
    @BindView(R.id.swlDescription) SwipeRefreshLayout swlDescription;
    @BindView(R.id.svMainContent) ScrollView svMainContent;

    @OnClick(R.id.ivActionShare) public void shareClicked(ImageView iv){
        if(item!=null){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TITLE,"Поделится");
            sendIntent.putExtra(Intent.EXTRA_SUBJECT,item.getTitle());
            sendIntent.putExtra(Intent.EXTRA_TEXT,item.getLink());
            sendIntent.setType("text/plain");
            activity.startActivity(Intent.createChooser(sendIntent, "Поделиться"));
        }
    }

    @OnClick(R.id.ivActionShoped) public void shopedCLicked(ImageView iv){
        new MaterialDialog.Builder(activity)
                .title("Featured...")
                .content("Пока такого нет.")
                .theme(Theme.LIGHT)
                .onPositive((dialog, which) -> {
                    dialog.dismiss();
                })
                .positiveText("OK")
                .show();
    }

    //endregion

    //region Activity vars
    AppCompatActivity activity;
    MaterialMenuDrawable materialMenu;
    AdapterVPImages adapterVPImages;
    FragmentManager fragmentManager;
    TdiscountDesc item;
    //endregion


    //region Activity LifeCycleMethods
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_discount_desc);
        activity = this;
        ((MainApplication)activity.getApplication()).getmNetComponent().inject(this);
        fragmentManager = getSupportFragmentManager();
        ButterKnife.bind(this);
        initUI();
        swlDescription.setRefreshing(true);
        loadDescription();
    }

    //endregion


    //region initialization UI on screen

    public void initUI(){
        swlDescription.setColorSchemeColors(activity.getResources().getColor(R.color.colorPrimary));

        setSupportActionBar(tbDescriptionScreen);
        activity.getSupportActionBar().setTitle("");
        materialMenu = new MaterialMenuDrawable(activity, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        materialMenu.setIconState(MaterialMenuDrawable.IconState.ARROW);
        tbDescriptionScreen.setNavigationIcon(materialMenu);

        tlPagerTabsDiscount.addTab(tlPagerTabsDiscount.newTab().setText("Условия"));
        tlPagerTabsDiscount.addTab(tlPagerTabsDiscount.newTab().setText("Описание"));

        tlPagerTabsDiscount.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        StringBuilder termText = new StringBuilder();
                        for(String term: item.getTerms()){
                            termText.append(term);
                        }
                        fragmentManager.beginTransaction().replace(R.id.frTextContent, FRTextBlock.newInstance(termText.toString())).commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction().replace(R.id.frTextContent, FRTextBlock.newInstance(item.getFeatures())).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    //endregion

    public void showDescription(TdiscountDesc desc) {
        swlDescription.post(() -> {
            swlDescription.setRefreshing(false);
        });
        adapterVPImages = new AdapterVPImages(fragmentManager,desc.getImages(),activity);
        vpDescriptionSlider.setAdapter(adapterVPImages);
        ipIndicator.setViewPager(vpDescriptionSlider);
        tvCellDiscountOldPrice.setText(desc.getFullPrice()+" тг");
        tvCellDiscountOldPrice.setPaintFlags(tvCellDiscountOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        tvCellDiscountNewPrice.setText(desc.getPrice()+" тг");
        tvDiscountTitle.setText(desc.getTitle());

        StringBuilder termText = new StringBuilder();
        for(String term: desc.getTerms()){
            termText.append(term);
        }
        fragmentManager.beginTransaction().replace(R.id.frTextContent, FRTextBlock.newInstance(termText.toString())).commit();

        svMainContent.setVisibility(View.VISIBLE);
    }

    public void loadDescription(){
        swlDescription.post(() -> {
           swlDescription.setRefreshing(true);
        });
        Observable<Response<TgeneralRequestAnswer<TdiscountDesc>>> observable = restAdapter.getDiscountDescription();
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tgeneralRequestAnswerResponse -> {
                    swlDescription.setEnabled(false);
                    item = tgeneralRequestAnswerResponse.body().getResult();

                    showDescription(item);
                },throwable -> {
                    swlDescription.setEnabled(false);
                    swlDescription.setRefreshing(false);
                    new MaterialDialog.Builder(activity)
                            .title("Ошибка")
                            .content("Ошибка запроса. Повторите Ваш запрос.")
                            .theme(Theme.LIGHT)
                            .onPositive((dialog, which) -> {
                                dialog.dismiss();
                            })
                            .positiveText("OK")
                            .show();
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                activity.finish();
        }
        return true;
    }

}
