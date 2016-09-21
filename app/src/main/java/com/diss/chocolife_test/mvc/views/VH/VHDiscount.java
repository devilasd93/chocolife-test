package com.diss.chocolife_test.mvc.views.VH;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.diss.chocolife_test.R;
import com.diss.chocolife_test.mvc.models.TdiscountShort;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dmitry on 19.09.16.
 */

public class VHDiscount extends RecyclerView.ViewHolder {


    //region ButterKnife Views Binding

    public @BindView(R.id.llRootCellDiscount) LinearLayout llRootCellDiscount;
    @BindView(R.id.ivCellDiscountMainPhoto) ImageView ivCellDiscountMainPhoto;
    @BindView(R.id.tvCellDiscountEco) TextView tvCellDiscountEco;
    @BindView(R.id.tvCellDiscountBuyCount) TextView tvCellDiscountBuyCount;
    @BindView(R.id.tvCellDiscountTitle) TextView tvCellDiscountTitle;
    @BindView(R.id.tvCellDiscountOldPrice) TextView tvCellDiscountOldPrice;
    @BindView(R.id.tvCellDiscountNewPrice) TextView tvCellDiscountNewPrice;


    //endregion

    public VHDiscount(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    //region View holder render method

    public void render(TdiscountShort item,Context context){
        Picasso.with(context).load(item.getImageUrl()).into(ivCellDiscountMainPhoto);
        tvCellDiscountEco.setText(-item.getDiscount()+"%");
        tvCellDiscountBuyCount.setText("Купили:\n"+item.getBought());
        tvCellDiscountTitle.setText(item.getTitle());
        tvCellDiscountOldPrice.setText(item.getFullPrice()+" тг");
        tvCellDiscountOldPrice.setPaintFlags(tvCellDiscountOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        tvCellDiscountNewPrice.setText(item.getPrice()+" тг");
        llRootCellDiscount.setOnClickListener(view -> {

        });
    }

    //endregion

}
