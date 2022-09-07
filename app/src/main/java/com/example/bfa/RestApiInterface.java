package com.example.bfa;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface RestApiInterface {

    @GET("user/profile/")
    public Call<Response> getProfile();

    //It needs Authorization Token
    @GET("user/profile/")
    public Call<Response> getProfile(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name);
}
