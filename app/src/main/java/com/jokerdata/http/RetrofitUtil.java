package com.jokerdata.http;

import android.util.Log;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oldma on 2018/2/24.
 */

public class RetrofitUtil {

    public static Retrofit mRetrofit;
    private static RetrofitService service;
    static {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BaseHttp.URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .client(getOkHttpClient())//使用本地OkHttp
                .build();
    }

    public static RetrofitService getInstance(){

        if(mRetrofit!=null){
            service = mRetrofit.create(RetrofitService.class);
        }

        return  service;
    }

    private static OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("oldMa","**OkHttp====Message**:"+message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient

                .Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }
}
