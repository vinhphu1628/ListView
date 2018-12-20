package com.example.win7.listview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WIN7 on 27/03/2018.
 */

public class ApiController implements retrofit2.Callback<ApiData> {
    public static final String BASE_URL = "http://test.apitiny.com/api/bkit/";
    public ApiListener listener;

    public interface ApiListener{
        void onGetData(ApiData data);
        void onFail(Throwable t);
    }

    public void addListener(ApiListener listener){
        this.listener = listener;
    }

    @Override
    public void onResponse(Call<ApiData> call, Response<ApiData> response) {
        if(response.isSuccessful()){
            ApiData data = response.body();
            listener.onGetData(data);
        }
        else {
            ApiData data = new ApiData();
            try {
                data.errorMessage = response.errorBody().string();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            listener.onGetData(data);
        }
    }

    @Override
    public void onFailure(Call<ApiData> call, Throwable t) {
        listener.onFail(t);
        t.printStackTrace();
    }

    public ApiController getData(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        ApiRoute route = retrofit.create(ApiRoute.class);
        retrofit2.Call<ApiData> call = route.getData();
        call.enqueue(this);
        return this;
    }
}
