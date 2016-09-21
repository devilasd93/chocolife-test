package com.diss.chocolife_test.mvc.controllers.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.diss.chocolife_test.mvc.controllers.fragments.FRTextBlock;

import java.util.ArrayList;

/**
 * Created by dmitry on 20.09.16.
 */

public class AdapterVPTextBlock extends FragmentStatePagerAdapter {

    ArrayList<String> list;
    Context context;

    public AdapterVPTextBlock(FragmentManager fm,Context context, ArrayList<String> list) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return new FRTextBlock().newInstance(this.list.get(position));
    }

    @Override
    public int getCount() {
        return this.list.size();
    }
}
