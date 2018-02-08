package com.example.android.newmoviedb.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.adapter.movieadapter;
import com.example.android.newmoviedb.api.apiclient;
import com.example.android.newmoviedb.api.apiinterface;
import com.example.android.newmoviedb.model.Movie;
import com.example.android.newmoviedb.model.MovieResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main extends AppCompatActivity {

    RecyclerView mView;
    movieadapter adapter;
    List<MovieResult> movieresults;
    public static final String LOG_TAG = movieadapter.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mView = findViewById(R.id.movieview);
        mView.setLayoutManager(new GridLayoutManager(Main.this,2));

        movieload("now_playing");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listsort, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.now_playing){
            movieload("now_playing");
        } else if (id==R.id.popular){
            movieload("popular");
        } else if (id==R.id.top_rated){
            movieload("top_rated");
        } else if (id==R.id.upcoming){
            movieload("upcoming");
        }
        return super.onOptionsItemSelected(item);
    }


    private void movieload(String value){
        apiinterface api = apiclient.getRetrofit().create(apiinterface.class);
        Call<Movie> call = null;
        switch (value) {
            case "now_playing":
                call = api.getNowPlaying();
                break;
            case "popular":
                call = api.getPopular();
                break;
            case "top_rated":
                call = api.getTop_Rated();
                break;
            case "upcoming":
                call = api.getUpcoming();
                break;
        }

        assert call != null;
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, Response<Movie> response) {
                Movie movie = (Movie) response.body().getMovieresults();
                mView.setAdapter(new movieadapter(getApplicationContext(),movie));
                mView.smoothScrollToPosition(0);
                /*adapter = new movieadapter(movieresults);
                adapter.setData(movie.getMovieresults());
                mView.setAdapter(adapter);*/
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, Throwable t) {

            }
        });

    }
}
