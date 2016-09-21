package com.diss.chocolife_test.mvc.controllers.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.diss.chocolife_test.mvc.controllers.fragments.FRsliderImage;

import java.util.ArrayList;


/**
 * Created by dmitry on 20.09.16.
 */

public class AdapterVPImages extends FragmentStatePagerAdapter {

    ArrayList<String> list;
    Context context;

    public AdapterVPImages(FragmentManager fm, ArrayList<String> list,Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return FRsliderImage.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return this.list.size();
    }
}
