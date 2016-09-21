package com.diss.chocolife_test.mvc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.realm.RealmObject;

/**
 * Created by dmitry on 19.09.16.
 */

public class TdiscountShort extends RealmObject{

    @Expose
    @SerializedName("deal_id")
    private int dealID;


    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("full_title")
    private String fullTitle;

    @Expose
    @SerializedName("deal_type")
    private String dealType;

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
    private long expireTime;

    @Expose
    @SerializedName("timeout")
    private long timeout;

    @Expose
    @SerializedName("reviews_number")
    private int reviewsNumber;

    @Expose
    @SerializedName("reviews_rate")
    private double reviewsRate;

    @Expose
    @SerializedName("questions_number")
    private int questionsNumber;


    @Expose
    @SerializedName("image_url")
    private String imageUrl;

    @Expose
    @SerializedName("link")
    private String link;

    @Expose
    @SerializedName("highlight_color")
    private String highlightColor;

    @Expose
    @SerializedName("video")
    private String video;

    @Expose
    @SerializedName("interested")
    private int interested;

    @Expose
    @SerializedName("deal_kind")
    private String dealKind;


    public int getDealID() {
        return dealID;
    }

    public void setDealID(int dealID) {
        this.dealID = dealID;
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

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
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

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public int getReviewsNumber() {
        return reviewsNumber;
    }

    public void setReviewsNumber(int reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
    }

    public double getReviewsRate() {
        return reviewsRate;
    }

    public void setReviewsRate(double reviewsRate) {
        this.reviewsRate = reviewsRate;
    }

    public int getQuestionsNumber() {
        return questionsNumber;
    }

    public void setQuestionsNumber(int questionsNumber) {
        this.questionsNumber = questionsNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHighlightColor() {
        return highlightColor;
    }

    public void setHighlightColor(String highlightColor) {
        this.highlightColor = highlightColor;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getInterested() {
        return interested;
    }

    public void setInterested(int interested) {
        this.interested = interested;
    }

    public String getDealKind() {
        return dealKind;
    }

    public void setDealKind(String dealKind) {
        this.dealKind = dealKind;
    }
}
