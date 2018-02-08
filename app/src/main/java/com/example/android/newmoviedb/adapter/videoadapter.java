package com.example.android.newmoviedb.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.model.VideoResult;

import java.util.List;

/**
 * Created by Atika on 2/7/2018.
 */

public class videoadapter extends RecyclerView.Adapter<videoadapter.videoholder>{

    private Context context;
    private List<VideoResult> videoResults;

    public videoadapter(Context context, List<VideoResult>videoResults){
        this.context = context;
        this.videoResults = videoResults;
    }

    @Override
    public videoholder onCreateViewHolder(ViewGroup parent, int i) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video, parent, false);

        return new videoholder(view);
    }

    @Override
    public void onBindViewHolder( videoholder holder, int i) {
        holder.videoname.setText(videoResults.get(i).getName());
    }

    public  void setDatareview(List<VideoResult>videoResults){
        this.videoResults = videoResults;
    }

    @Override
    public int getItemCount() {

        return videoResults.size();
    }


     class videoholder extends RecyclerView.ViewHolder{
        ImageView videoimage;
        TextView videoname;

        public videoholder(View itemView) {
            super(itemView);
            videoimage = itemView.findViewById(R.id.videoimage);
            videoname = itemView.findViewById(R.id.videoname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos !=RecyclerView.NO_POSITION){
                        VideoResult clickedDataItem = videoResults.get(pos);
                        String videoId = videoResults.get(pos).getKey();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+videoId));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("video_id", videoId);
                        context.startActivity(intent);

                        Toast.makeText(view.getContext(), "You Clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
