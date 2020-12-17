package com.example.myapplication.api;

import android.content.ClipData;

import com.example.myapplication.base.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SevenApi {
    String Url="https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/2")
    Observable<Result>getResult();

}
