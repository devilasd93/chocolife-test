package com.diss.chocolife_test.mvc.controllers.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diss.chocolife_test.R;
import com.diss.chocolife_test.mvc.controllers.activities.ActDiscountDescription;
import com.diss.chocolife_test.mvc.models.TdiscountShort;
import com.diss.chocolife_test.mvc.views.VH.VHDiscount;

import java.util.ArrayList;

/**
 * Created by dmitry on 19.09.16.
 */

public class AdapterListDiscount extends RecyclerView.Adapter<VHDiscount> {


    ArrayList<TdiscountShort> list;
    Context context;

    public AdapterListDiscount(ArrayList<TdiscountShort> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public VHDiscount onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.cell_item_discount,parent,false);
        return new VHDiscount(view);
    }

    @Override
    public void onBindViewHolder(VHDiscount holder, int position) {
        holder.render(list.get(position),context);
        holder.llRootCellDiscount.setOnClickListener(view -> {
            Intent intent = new Intent(context, ActDiscountDescription.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
