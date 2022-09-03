package com.example.bfa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myapi {
    @GET("user/profile")
    Call<model> getmodels();
}
