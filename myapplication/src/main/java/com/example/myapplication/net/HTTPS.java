package com.example.myapplication.net;

import com.example.myapplication.api.SevenApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HTTPS {
    private static HTTPS https;
    public static HTTPS getInstance(){
        if(https==null){
            synchronized (HTTPS.class){
                https=new HTTPS();
            }
        }
        return https;
    }
    private static SevenApi sevenApi;
    private Retrofit getretrofit(){
        Retrofit build = new Retrofit.Builder()
                .client(getokHttpClient())
                .baseUrl(SevenApi.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return build;
    }
    private OkHttpClient getokHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Lought())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }
    static class Lought implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }
    public  SevenApi getSevenApi(){
        if(sevenApi==null){
            sevenApi=getretrofit().create(SevenApi.class);
        }
        return sevenApi;
    }
}
