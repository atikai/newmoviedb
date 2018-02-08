package com.example.android.newmoviedb.model;

import java.util.List;

/**
 * Created by Atika on 2/7/2018.
 */

public class Review {
    private int id;
    private int page;
    private List<ReviewResult> reviewresults;
    private int total_pages;
    private int total_results;


    public int getId() {
        return id;
    }

    public int getPage() {
        return page;
    }

    public List<ReviewResult> getReviewresults() {
        return reviewresults;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }
}
