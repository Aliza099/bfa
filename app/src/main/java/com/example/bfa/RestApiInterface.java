package com.example.bfa;

import PojoModels.Library;
import PojoModels.PojoBookshop;
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
    public Call<Library> getLibrary();

    @GET("content/writers")
   public Call<PojoWriters> getWriter();

}
