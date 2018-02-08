package com.example.android.newmoviedb.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.adapter.videoadapter;
import com.example.android.newmoviedb.model.MovieResult;
import com.example.android.newmoviedb.model.Video;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Atika on 2/4/2018.
 */

public class DetailMovie extends AppCompatActivity{
    ImageView Poster;
    TextView Judul, Genre, Tanggal, Rating, Sinopsis;
    private RecyclerView recyclerView;
    private videoadapter adapter;
    private List<Video> videoList;
    /*VideoView Video;*/

    MovieResult movieresults;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmovie);
        Poster = (ImageView)findViewById(R.id.poster);
        Judul = (TextView)findViewById(R.id.judul);
        Genre = (TextView)findViewById(R.id.genre);
        Tanggal = (TextView)findViewById(R.id.tanggal);
        Rating = (TextView)findViewById(R.id.rating);
        Sinopsis = (TextView)findViewById(R.id.sinopsis);
       /* Video = (VideoView)findViewById(R.id.video);*/

        movieresults = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("Movie"), MovieResult.class);
        Picasso.with(DetailMovie.this)
                .load("http://image.tmdb.org/t/p/w185/"+ movieresults.getPosterPath())
                .into(Poster);
        Judul.setText(movieresults.getTitle());
        Genre.setText("Genre : " + movieresults.getGenreIds());
        Tanggal.setText("Release Date : " + movieresults.getReleaseDate());
        Rating.setText("Vote Average : " + Double.toString(movieresults.getVoteAverage()));
        Sinopsis.setText("Description : " + movieresults.getOverview());

    }
}
