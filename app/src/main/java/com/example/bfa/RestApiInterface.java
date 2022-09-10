package com.example.bfa;

import PojoModels.PojoBookshop;
import PojoModels.PojoLibrary;
import PojoModels.Update;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiInterface {
 // for profile Activity
    @GET("user/profile")
    public Call<Update> getProfile();

    // for Bookshops Activity

    @GET("content/bookshops")
    public Call<PojoBookshop> getBook();

    @GET("content/libraries")
    public Call<PojoLibrary> getLibrary();

}
