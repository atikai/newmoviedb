package com.example.android.newmoviedb.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Atika on 2/4/2018.
 */

public class apiclient {
    public static final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
