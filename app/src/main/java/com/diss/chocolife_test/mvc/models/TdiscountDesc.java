package com.diss.chocolife_test.mvc.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by dmitry on 20.09.16.
 */

public class TdiscountDesc {

    @Expose
    @SerializedName("deal_id")
    private int dealID;

    @Expose
    @SerializedName("images")
    private ArrayList<String> images;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("full_title")
    private String fullTitle;

    @Expose
    @SerializedName("price")
    private int price;

    @Expose
    @SerializedName("discount")
    private int discount;

    @Expose
    @SerializedName("bought")
    private int bought;

    @Expose
    @SerializedName("full_price")
    private int fullPrice;

    @Expose
    @SerializedName("economy")
    private int economy;

    @Expose
    @SerializedName("expiry_time")
    private int expireTime;

    @Expose
    @SerializedName("timeout")
    private int timeout;

    @Expose
    @SerializedName("reviews_number")
    private int reviewsNumber;

    @Expose
    @SerializedName("reviews_rate")
    private int reviewsRate;

    @Expose
    @SerializedName("questions_number")
    private int qustionsNumber;

    @Nullable
    @Expose
    @SerializedName("places")
    private ArrayList<Tplace> places;

    @Expose
    @SerializedName("partner_phones")
    private ArrayList<String> partnerPhones;

    @Expose
    @SerializedName("partner_url")
    private String partnerUrl;

    @Expose
    @SerializedName("desc")
    private String desc;

    @Expose
    @SerializedName("terms")
    private ArrayList<String> terms;

    @Expose
    @SerializedName("features")
    private String features;

    @Expose
    @SerializedName("link")
    private String link;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("towns")
    private ArrayList<Ttown> towns;

    @Expose
    @SerializedName("categories")
    private ArrayList<Tcategory> categories;

    @Expose
    @SerializedName("expiry_date")
    private String expiryDate;

    public int getDealID() {
        return dealID;
    }

    public void setDealID(int dealID) {
        this.dealID = dealID;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getReviewsNumber() {
        return reviewsNumber;
    }

    public void setReviewsNumber(int reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
    }

    public int getReviewsRate() {
        return reviewsRate;
    }

    public void setReviewsRate(int reviewsRate) {
        this.reviewsRate = reviewsRate;
    }

    public int getQustionsNumber() {
        return qustionsNumber;
    }

    public void setQustionsNumber(int qustionsNumber) {
        this.qustionsNumber = qustionsNumber;
    }

    @Nullable
    public ArrayList<Tplace> getPlaces() {
        return places;
    }

    public void setPlaces(@Nullable ArrayList<Tplace> places) {
        this.places = places;
    }

    public ArrayList<String> getPartnerPhones() {
        return partnerPhones;
    }

    public void setPartnerPhones(ArrayList<String> partnerPhones) {
        this.partnerPhones = partnerPhones;
    }

    public String getPartnerUrl() {
        return partnerUrl;
    }

    public void setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<String> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<String> terms) {
        this.terms = terms;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Ttown> getTowns() {
        return towns;
    }

    public void setTowns(ArrayList<Ttown> towns) {
        this.towns = towns;
    }

    public ArrayList<Tcategory> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Tcategory> categories) {
        this.categories = categories;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}