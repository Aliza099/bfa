package com.example.bfa;

import PojoModels.Bookshops;
import PojoModels.Browse;
import PojoModels.BrowseChip;
import PojoModels.LibList;
import PojoModels.Library;
import PojoModels.Update;
import PojoModels.Writer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

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

    @GET("content")
    public Call<Browse> getBrowseList();

    @GET("{fulUrl}")
    public Call<LibList> getLibBooks(@Path(value = "fulUrl", encoded = true) String fulUrl);

    @GET("content/book-categories")
    public Call<BrowseChip> getBrowseChip();




}
