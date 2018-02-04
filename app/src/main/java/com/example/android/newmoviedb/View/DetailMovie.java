package com.example.android.newmoviedb.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.model.Result;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

/**
 * Created by Atika on 2/4/2018.
 */

public class DetailMovie extends AppCompatActivity{
    ImageView Poster;
    TextView Judul, Genre, Tanggal, Rating, Sinopsis;
    /*VideoView Video;*/

    Result results;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsmovie);
        Poster = (ImageView)findViewById(R.id.poster);
        Judul = (TextView)findViewById(R.id.judul);
        Genre = (TextView)findViewById(R.id.genre);
        Tanggal = (TextView)findViewById(R.id.tanggal);
        Rating = (TextView)findViewById(R.id.rating);
        Sinopsis = (TextView)findViewById(R.id.sinopsis);
       /* Video = (VideoView)findViewById(R.id.video);*/

        results = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), Result.class);
        Picasso.with(DetailMovie.this)
                .load("http://image.tmdb.org/t/p/w185/"+ results.getPosterPath())
                .into(Poster);
        Judul.setText(results.getTitle());
        Genre.setText("Genre : "+results.getGenreIds());
        Tanggal.setText("Release Date : "+results.getReleaseDate());
        Rating.setText("Vote Average : "+ Double.toString(results.getVoteAverage()));
        Sinopsis.setText("Description : "+results.getOverview());
        /*Video.setVideoURI("");*/
    }
}
