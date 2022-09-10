package com.example.bfa;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {

//    private static final String url = "https://bfinder-be.herokuapp.com/api/";
//    private static RestApi clientObject;
//    private static Retrofit retrofit;
//
//    RestApi(){
//        retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    public static synchronized RestApi getInstance()
//    {
//        if(clientObject==null)
//            clientObject=new RestApi();
//        return clientObject;
//    }
//    RestApiInterface getApi()
//    {
//        return retrofit.create(RestApiInterface.class);
//    }
//
//}

    public static RestApiInterface getClients() {
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("https://bfinder-be.herokuapp.com/api/") //Setting the Root URL
                .addConverterFactory(GsonConverterFactory.create())
                .build(); //Finally building the adapter

        //Creating object for our interface
        RestApiInterface api = adapter.create(RestApiInterface.class);
        return api;
    }

    public static RestApiInterface getClients(String save) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder newRequest = request.newBuilder().header("Authorization", save);
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





