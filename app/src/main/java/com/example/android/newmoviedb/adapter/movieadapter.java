package com.example.android.newmoviedb.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.View.DetailMovie;
import com.example.android.newmoviedb.model.MovieResult;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by Atika on 2/4/2018.
 */

public class movieadapter extends RecyclerView.Adapter<movieadapter.movieholder> {
    private List<MovieResult> movieresults;
    private Context context;

    public movieadapter(Context context, List<MovieResult> movieresults){
        this.context=context;
        this.movieresults=movieresults;
    }

    @Override
    public movieholder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listmovie, parent, false);
        return new movieholder(view);
    }



    @Override
    public void onBindViewHolder(final movieholder holder, final int i) {
         Picasso.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185/"+movieresults.get(i).getPosterPath())
                .into(holder.Poster);

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (pos!= RecyclerView.NO_POSITION){
                    MovieResult clickedDataItem = movieresults.get(pos);
                    Intent intent = new Intent(holder.itemView.getContext(), DetailMovie.class);
                    intent.putExtra("movie",new GsonBuilder().create().toJson(clickedDataItem));
                    holder.itemView.getContext().startActivity(intent);}}});}

                            /*(Parcelable) clickedDataItem);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(view.getContext(),"You Clicked " + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();}}}*/


            holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MovieResult data = movieresults.get(i);
                Intent intent = new Intent(holder.itemView.getContext(), DetailMovie.class);
                intent.putExtra("movie", new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivity(intent);
            }
        });}



    public void setData(List<MovieResult> movieresults){
        this.movieresults = movieresults;
    }

    @Override
    public int getItemCount() {
        return movieresults.size();
    }

     class movieholder extends RecyclerView.ViewHolder{
        ImageView Poster;
        public movieholder(View itemView) {
            super(itemView);
            Poster = itemView.findViewById(R.id.poster);}}}

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos!= RecyclerView.NO_POSITION){
                        MovieResult clickedDataItem = movieresults.get(pos);
                        Intent intent = new Intent(context, DetailMovie.class);
                        intent.putExtra("movie", (Parcelable) clickedDataItem);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(view.getContext(),"You Clicked " + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();

                    }
                }
            }*/