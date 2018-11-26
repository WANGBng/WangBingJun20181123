package com.bwie.my.util;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class HttpUtils {

    public final Api api;

    private HttpUtils(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new Logging()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contast.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        api = retrofit.create(Api.class);
    }
     class Logging implements Interceptor {//这是我自己自定义的拦截器
         @Override
         public Response intercept(Chain chain) throws IOException {
             Request request = chain.request();
             Request.Builder builder = chain.request().newBuilder().addHeader("source","android");
             Response proceed=chain.proceed(request);
             return proceed;
         }
     }

     private static class GetDataNet{
        private  static HttpUtils httpUtils = new HttpUtils();
     }
     public static HttpUtils getdatanet(){
        return GetDataNet.httpUtils;
     }
}
