package com.example.bfa;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {

    public static RestApiInterface getField(){
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("https://bfinder-be.herokuapp.com/api/") //Setting the Root URL
                .addConverterFactory(GsonConverterFactory.create())
                .build(); //Finally building the adapter

        //Creating object for our interface
        RestApiInterface api = adapter.create(RestApiInterface.class);
        return api;
    }
    public static RestApiInterface getField(String token) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder newRequest = request.newBuilder().header("Authorization", token);
                        return chain.proceed(newRequest.build());

                    }
                });
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("https://bfinder-be.herokuapp.com/api/") //Setting the Root URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build(); //Finally building the adapter
        RestApiInterface api = adapter.create(RestApiInterface.class);
        return api;
    }

}
