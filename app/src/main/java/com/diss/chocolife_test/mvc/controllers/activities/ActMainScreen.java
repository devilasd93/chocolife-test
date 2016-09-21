package com.diss.chocolife_test.mvc.controllers.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.balysv.materialmenu.MaterialMenuDrawable;
import com.diss.chocolife_test.R;
import com.diss.chocolife_test.mvc.controllers.fragments.FRdiscountsList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dmitry on 19.09.16.
 */

public class ActMainScreen extends AppCompatActivity {

    //region Dagger 2 injections
    //endregion

    //region ButterKnife Views bindings

    @BindView(R.id.dlRootLayout) DrawerLayout dlRootLayout;
    @BindView(R.id.tbMainScreen) Toolbar tbMainScreen;

    @OnClick(R.id.ivSearch) public void shareClicked(ImageView iv){
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
    FragmentManager fragmentManager;
    MaterialMenuDrawable materialMenu;
    //endregion


    //region Activity LifeCycle methods

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_screen);
        activity = this;
        fragmentManager = getSupportFragmentManager();
        ButterKnife.bind(this);
        initUI();
    }

    //endregion


    //region Init UI method
    public void initUI(){
        setSupportActionBar(tbMainScreen);
        activity.getSupportActionBar().setTitle("");

        materialMenu = new MaterialMenuDrawable(activity, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        materialMenu.setIconState(MaterialMenuDrawable.IconState.BURGER);
        tbMainScreen.setNavigationIcon(materialMenu);

        fragmentManager.beginTransaction().replace(R.id.flMainContentContainer, FRdiscountsList.newInstance()).commit();
    }

    //endregion

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(dlRootLayout.isDrawerOpen(Gravity.RIGHT)||(dlRootLayout.isDrawerOpen(Gravity.LEFT))){
                dlRootLayout.closeDrawers();
                return false;
            }else{
                return super.onKeyDown(keyCode,event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                dlRootLayout.openDrawer(Gravity.LEFT);
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
