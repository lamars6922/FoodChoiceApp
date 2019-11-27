package com.example.myapplication;


import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {
    String URL = "http://----/";

    @GET("food/")
    Call<List<Data>>  getData();

    @FormUrlEncoded
    @POST("food/")
    Call<Data> postData(@FieldMap HashMap<String, String> param);

}
