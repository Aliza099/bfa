package com.example.bfa;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface RestApiInterface {
 // for profile Activity
    @GET("user/profile/")
    public Call<POJOModels> getProfile();

    // for Bookshops Activity

    @GET("content/bookshops")
    public Call<PojoBookshop> getBook();

}
