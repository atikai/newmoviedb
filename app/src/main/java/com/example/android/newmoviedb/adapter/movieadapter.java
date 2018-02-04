package com.example.android.newmoviedb.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.View.DetailMovie;
import com.example.android.newmoviedb.model.Movie;
import com.example.android.newmoviedb.model.Result;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Atika on 2/4/2018.
 */

public class movieadapter extends RecyclerView.Adapter<movieadapter.movieholder> {
    List<Result> results;

    public movieadapter(List<Result> results) {
        this.results = results;
    }

    @Override
    public movieholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.listmovie, parent, false);
        return new movieholder(view);
    }

    @Override
    public void onBindViewHolder(final movieholder holder, final int position) {
        Picasso.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185/"+results.get(position).getPosterPath())
                .into(holder.Poster);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Result data = results.get(position);
                Intent i = new Intent(holder.itemView.getContext(), DetailMovie.class);
                i.putExtra("movie", new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    public void setData(List<Result> results){
        this.results = results;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class movieholder extends RecyclerView.ViewHolder{
        ImageView Poster;
        public movieholder(View itemView) {
            super(itemView);
            Poster = (ImageView)itemView.findViewById(R.id.poster);
        }
    }
}
