package com.example.augustandroid;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("login/v2/getOtp")
    Call<ResponseModel> createUser(@Body JsonObject request);

    @GET("http://www.omdbapi.com/?")
    Call<MovieResponse> getMovies(@Query("s") String title, @Query("apikey") String apiKey);
}
