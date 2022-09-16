package com.example.bfa;

import PojoModels.Bookshops;
import PojoModels.Library;
import PojoModels.Update;
import PojoModels.Writer;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiInterface {
 // for profile Activity
    @GET("user/profile")
    public Call<Update> getProfile();

    // for Bookshops Activity

    @GET("content/bookshops")
    public Call<Bookshops> getBook();

    @GET("content/libraries")
    public Call<Library> getLibrary();

    @GET("content/writers")
   public Call<Writer> getWriter();




}
