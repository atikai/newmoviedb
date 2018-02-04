package com.example.android.newmoviedb.api;

import com.example.android.newmoviedb.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

import java.lang.String;
/**
 * Created by Atika on 2/4/2018.
 */

public interface apiinterface {
   public static String DB_API ="b8476da84f5edac5ca2f57c75e2597d5";
   @GET("now_playing?api_key="+DB_API)
    Call<Movie> getNowPlaying();

    @GET("popular?api_key="+DB_API)
    Call<Movie> getPopular();

    @GET("top_rated?api_key="+DB_API)
    Call<Movie> getTop_Rated();
}

