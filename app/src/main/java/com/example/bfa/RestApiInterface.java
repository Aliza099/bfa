package com.example.bfa;

import com.google.gson.JsonObject;

import PojoModels.BooksResponse;
import PojoModels.Bookshops;
import PojoModels.Browse;
import PojoModels.CategoryChip;
import PojoModels.GenreChip;
import PojoModels.LibList;
import PojoModels.Library;
import PojoModels.Update;
import PojoModels.Writer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApiInterface {
 // for profile Activity
    @GET("user/profile")
    public Call<Update> getProfile();

    // for Bookshops Activity
    @GET("content/bookshops")
    public Call<Bookshops> getBook();

    // for library Activity
    @GET("content/libraries")
    public Call<Library> getLibrary();

    // for writer Activity
    @GET("content/writers")
   public Call<Writer> getWriter();

    // Browse content Books List
    @GET("content")
    public Call<Browse> getBrowseList();

    // Books of lib,writer,bookshops
    @GET("{fulUrl}")
    public Call<LibList> getLibBooks(@Path(value = "fulUrl", encoded = true) String fulUrl);

    // for Browse Content Category Chip
    @GET("content/book-categories")
    public Call<CategoryChip> getBrowseChip();

    // for Browse Content Genre Chip
    @GET("content/genres")
    public Call<GenreChip> getGenreChip();

    @GET("content/writers/4")
    public Call<BooksResponse> getBooksDetail();

    // for Query String
    @GET("content?")
    public Call<Browse> getLocationInfo(@Query("Longitude") String longitude,
                                     @Query("Latitude") String latitude,
                                     @Query("title") String title,
                                     @Query("genres") int genres,
                                     @Query("book_category") int bookCategory);





}
