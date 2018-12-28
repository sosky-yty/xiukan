package com.example.sosky.xiukan;

import com.example.sosky.xiukan.adapter.item.Actores;
import com.example.sosky.xiukan.adapter.item.DataSource;
import com.example.sosky.xiukan.adapter.item.Movie;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Configurations {

    private static File file;

    private ArrayList<Movie> starred_movies;

    private ArrayList<Actores> starred_actresses;

    private DataSource data_source;

    private boolean show_ads;

    private long download_counter;

    public static Configurations load(File file) {
        Configurations.file = file;
        Configurations config = null;
        try {
            config = XiuKan.parseJson(Configurations.class, new JsonReader(new FileReader(file)));
        } catch (Exception ignored) {
        }

        if (config == null) {
            config = new Configurations();
        }

        return config;
    }

    public ArrayList<Movie> getStarredMovies() {
        if (starred_movies == null) {
            starred_movies = new ArrayList<>();
        }
        return starred_movies;
    }

    public ArrayList<Actores> getStarredActresses() {
        if (starred_actresses == null) {
            starred_actresses = new ArrayList<>();
        }
        return starred_actresses;
    }

    public DataSource getDataSource() {
        if (data_source == null) {
            data_source = XiuKan.DATA_SOURCES.get(0);
        }
        return data_source;
    }

    public void setDataSource(DataSource source) {
        this.data_source = source;
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter(file);
            new Gson().toJson(this, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setShowAds(boolean show_ads) {
        this.show_ads = show_ads;
    }

    public boolean showAds() {
        return show_ads;
    }

    public long getDownloadCounter() {
        return download_counter;
    }

    public void setDownloadCounter(long download_counter) {
        this.download_counter = download_counter;
    }
}
