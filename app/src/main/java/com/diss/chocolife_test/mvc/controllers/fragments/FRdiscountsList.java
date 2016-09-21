package com.diss.chocolife_test.mvc.controllers.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.diss.chocolife_test.R;
import com.diss.chocolife_test.mvc.controllers.adapters.AdapterListDiscount;
import com.diss.chocolife_test.mvc.controllers.application.MainApplication;
import com.diss.chocolife_test.mvc.models.TdiscountShort;
import com.diss.chocolife_test.mvc.models.answers.TgeneralRequestAnswer;
import com.diss.chocolife_test.mvc.support.RestAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dmitry on 19.09.16.
 */

public class FRdiscountsList extends Fragment {

    //region Dagger Injections
    @Inject RestAdapter restAdapter;
    //endregion

    //region ButterKnife Views bindins

    @BindView(R.id.swlDiscountList) SwipeRefreshLayout swlDiscountList;
    @BindView(R.id.rvDiscountsList) RecyclerView rvDiscountsList;

    //endregion


    //region fragment vars

    AppCompatActivity activity;
    LinearLayoutManager manager;
    AdapterListDiscount adapterListDiscount;
    ArrayList<TdiscountShort> dataList = new ArrayList<TdiscountShort>();
    Handler handler = new Handler();
    Realm realm;
    RealmResults<TdiscountShort> realmResults;

    //endregion

    //region new Instance net fragment
    public static FRdiscountsList newInstance() {

        Bundle args = new Bundle();
        FRdiscountsList fragment = new FRdiscountsList();
        fragment.setArguments(args);
        return fragment;
    }
    //endregion



    //region Fragment LifeCycles methods
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (AppCompatActivity)getActivity();
        ((MainApplication)activity.getApplication()).getmNetComponent().inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_layout_discount_list,container,false);
        ButterKnife.bind(this,view);
        realm = Realm.getDefaultInstance();
        initUI();
        loadCache();
        return view;
    }
    //endregion


    //region init ui method

    public void initUI(){
        swlDiscountList.setColorSchemeColors(activity.getResources().getColor(R.color.colorPrimary));
        manager = new LinearLayoutManager(activity);
        adapterListDiscount = new AdapterListDiscount(dataList,activity);
        rvDiscountsList.setLayoutManager(manager);
        rvDiscountsList.setAdapter(adapterListDiscount);
        swlDiscountList.setOnRefreshListener(() -> {
            loadMore();
        });
        loadMore();
    }

    //endregion

    //region loadMoreList method for dowloading list

    public void loadMore(){
        swlDiscountList.post(() -> {
            swlDiscountList.setRefreshing(true);
        });
        Observable<Response<TgeneralRequestAnswer<ArrayList<TdiscountShort>>>> observable =restAdapter.getDiscountsList();
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tgeneralRequestAnswerResponse -> {
                    dataList.clear();
                    realmResults = realm.where(TdiscountShort.class)
                            .findAll();
                    realm.beginTransaction();
                    realmResults.deleteAllFromRealm();
                    realm.commitTransaction();
                    for(TdiscountShort localItem: tgeneralRequestAnswerResponse.body().getResult()){
                        dataList.add(localItem);
                        realm.beginTransaction();
                        realm.insert(localItem);
                        realm.commitTransaction();
                    }
                    handler.post(() -> {
                        swlDiscountList.setRefreshing(false);
                        adapterListDiscount.notifyDataSetChanged();
                    });
                },throwable -> {
                    swlDiscountList.setRefreshing(false);
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

    //endregion

    //region loading last saved list items

    public void loadCache(){
        realmResults = realm.where(TdiscountShort.class)
                .findAll();
        if(realmResults.size()>0){
            dataList.addAll(realmResults.subList(0,realmResults.size()));
        }
    }

    //endregion

}
