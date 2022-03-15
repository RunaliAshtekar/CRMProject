package com.rsd.crmroject;

import androidx.viewpager2.widget.ViewPager2;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CheckinMethod {

    //https://api.pidu.in/mybiz/api/dummy-list

    @POST("dummy-list")
    Call<ResponseBody> getList(@Body JsonObject jsonObject);


}