package com.diss.chocolife_test.mvc.controllers.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diss.chocolife_test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dmitry on 20.09.16.
 */

public class FRTextBlock extends Fragment {

    @BindView(R.id.tvFragmentTextBlock) TextView tvFragmentTextBlock;

    String text="";

    public static FRTextBlock newInstance(String text) {
        Bundle args = new Bundle();
        FRTextBlock fragment = new FRTextBlock();
        args.putString("text",text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.text = getArguments().getString("text");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_text_block,container,false);
        ButterKnife.bind(this,view);
        tvFragmentTextBlock.setText(Html.fromHtml(text));
        return view;
    }
}
