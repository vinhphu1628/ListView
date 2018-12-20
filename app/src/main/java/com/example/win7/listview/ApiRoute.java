package com.example.win7.listview;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by WIN7 on 27/03/2018.
 */

public interface ApiRoute {
    @GET("data")
    Call<ApiData> getData();
}
