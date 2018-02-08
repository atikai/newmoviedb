package com.example.android.newmoviedb.model;

import java.util.List;

/**
 * Created by Atika on 2/7/2018.
 */

public class Video {
    private int id;
    private List<VideoResult> videoresults;

    public int getId() {
        return id;
    }

    public List<VideoResult> getVideoresults() {
        return videoresults;
    }
}
