package com.example.day_03_class.net;



import com.example.day_03_class.api.TomeApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Https {
    private static Https https;

    public static Https getHttps() {
        if (https == null) {
            synchronized (Https.class) {
                if (https == null) {
                    https = new Https();
                }
            }
        }
        return https;
    }

    private static TomeApi tomeApi;

    private Retrofit getretrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getokHttpClient())
                .baseUrl(TomeApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private OkHttpClient getokHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Lonhjk())
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }

    static class Lonhjk implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }

    public TomeApi getThomApi() {
        if (tomeApi == null) {
            tomeApi = getretrofit().create(TomeApi.class);
        }
        return tomeApi;
    }
}
