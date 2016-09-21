package com.diss.chocolife_test.mvc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dmitry on 20.09.16.
 */

public class Toffer {

    @Expose
    @SerializedName("offer_id")
    private int offerID;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("full_price")
    private String fullPrice;

    @Expose
    @SerializedName("price")
    private String price;

    @Expose
    @SerializedName("discount")
    private int discount;

    @Expose
    @SerializedName("bought")
    private int bought;

    @Expose
    @SerializedName("available_number")
    private int availableNumber;

    @Expose
    @SerializedName("expiry_date")
    private String expireDate;


}
