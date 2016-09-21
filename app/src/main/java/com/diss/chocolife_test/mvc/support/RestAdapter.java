package com.diss.chocolife_test.mvc.support;

import com.diss.chocolife_test.mvc.models.TdiscountDesc;
import com.diss.chocolife_test.mvc.models.TdiscountShort;
import com.diss.chocolife_test.mvc.models.answers.TgeneralRequestAnswer;

import java.util.ArrayList;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;
import rx.android.BuildConfig;

/**
 * Created by dmitry on 19.09.16.
 */

public interface RestAdapter {

    @GET(Zvars.URL_LIST)
    Observable<Response<TgeneralRequestAnswer<ArrayList<TdiscountShort>>>> getDiscountsList();

    @GET(Zvars.URL_GET_DISCOUNT_BY_ID)
    Observable<Response<TgeneralRequestAnswer<TdiscountDesc>>> getDiscountDescription();


}
