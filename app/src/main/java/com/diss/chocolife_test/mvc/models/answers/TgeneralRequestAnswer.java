package com.diss.chocolife_test.mvc.models.answers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by dmitry on 20.09.16.
 */

public class TgeneralRequestAnswer<T> {

    @Expose
    @SerializedName("error_code")
    private int errorCode;

    @Expose
    @SerializedName("error_msg")
    private String errorMsg;

    @Expose
    @SerializedName("result")
    private T result;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
