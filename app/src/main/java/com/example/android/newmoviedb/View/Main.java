package com.example.android.newmoviedb.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.adapter.movieadapter;
import com.example.android.newmoviedb.model.Movie;
import com.example.android.newmoviedb.api.apiinterface;
import com.example.android.newmoviedb.api.apiclient;
import com.example.android.newmoviedb.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main extends AppCompatActivity {

    RecyclerView mView;
    movieadapter adapter;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mView = (RecyclerView)findViewById(R.id.movieview);
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
        }
        return super.onOptionsItemSelected(item);
    }


    private void movieload(String value){
        apiinterface api = apiclient.getRetrofit().create(apiinterface.class);
        Call<Movie> call = null;
        if (value.equals("now_playing")){
            call=api.getNowPlaying();
        }else if (value.equals("popular")){
            call=api.getPopular();
        }else if (value.equals("top_rated")){
            call=api.getTop_Rated();
        }

        call.enqueue((new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                adapter = new movieadapter(results);
                adapter.setData(movie.getResults());
                mView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        }));

    }
}
