package com.example.android.newmoviedb.model;

/**
 * Created by Atika on 2/4/2018.
 */
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Movie implements List<MovieResult> {

    @SerializedName("results")
    @Expose
    private List<MovieResult> movieresults = null;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;


    public List<MovieResult> getMovieresults() {
        return movieresults;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public Dates getDates() {
        return dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator<MovieResult> iterator() {
        return null;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] ts) {
        return null;
    }

    @Override
    public boolean add(MovieResult movieResult) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends MovieResult> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends MovieResult> collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public MovieResult get(int i) {
        return null;
    }

    @Override
    public MovieResult set(int i, MovieResult movieResult) {
        return null;
    }

    @Override
    public void add(int i, MovieResult movieResult) {

    }

    @Override
    public MovieResult remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<MovieResult> listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator<MovieResult> listIterator(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<MovieResult> subList(int i, int i1) {
        return null;
    }
}
