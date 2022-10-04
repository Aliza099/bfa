package com.example.bfa;

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

    @GET("content/writers/7")
    public Call<BooksResponse> getBooksDetail();




}
