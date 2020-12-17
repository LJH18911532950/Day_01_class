package com.example.app3.api;


import com.example.app3.base.Item;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TomeApi {
    String URL="https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/2")
    Observable<Item> getItem();

}
