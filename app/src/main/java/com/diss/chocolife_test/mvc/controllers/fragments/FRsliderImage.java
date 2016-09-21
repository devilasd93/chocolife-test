package com.diss.chocolife_test.mvc.controllers.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.diss.chocolife_test.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dmitry on 20.09.16.
 */

public class FRsliderImage extends Fragment {

    @BindView(R.id.ivImageSlider) ImageView ivImageSlider;
    AppCompatActivity activity;
    String imageURL;

    public static FRsliderImage newInstance(String imageUrl) {
        Bundle args = new Bundle();
        args.putString("image",imageUrl);
        FRsliderImage fragment = new FRsliderImage();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (AppCompatActivity) getActivity();
        imageURL = getArguments().getString("image");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_image,container,false);
        ButterKnife.bind(this,view);
        Picasso.with(activity).load(imageURL).into(ivImageSlider);
        return view;
    }
}
