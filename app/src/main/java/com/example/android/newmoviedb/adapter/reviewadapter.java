package com.example.android.newmoviedb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.newmoviedb.R;
import com.example.android.newmoviedb.model.ReviewResult;

import java.util.List;

/**
 * Created by Atika on 2/7/2018.
 */

public class reviewadapter extends RecyclerView.Adapter<reviewadapter.reviewholder>{

    private Context context;
    private List<ReviewResult> reviewResult;

    public reviewadapter(Context context, List<ReviewResult>reviewResult){
        this.context = context;
        this.reviewResult = reviewResult;
    }

    @Override
    public reviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review, parent, false);
        return new reviewholder(view);
    }

    @Override
    public void onBindViewHolder(reviewholder holder, int i) {
            holder.reviewauthor.setText(reviewResult.get(i).getAuthor());
    }

    public  void setDatareview(List<ReviewResult>reviewResult){
        this.reviewResult = reviewResult;
    }
    @Override
    public int getItemCount() {

        return reviewResult.size();
    }

    class reviewholder extends RecyclerView.ViewHolder{
        TextView reviewauthor, reviewcontent;
        public reviewholder(View itemView) {
            super(itemView);
            reviewauthor = (TextView)itemView.findViewById(R.id.review_author);
            reviewcontent = (TextView)itemView.findViewById(R.id.review_content);
        }
    }
}
