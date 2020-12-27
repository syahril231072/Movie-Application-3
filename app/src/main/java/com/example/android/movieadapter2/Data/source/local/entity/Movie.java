package com.example.android.movieadapter2.Data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie {
    private Integer id;
    private String title;
    private String release;
    private String desc;
    private String movieBg;

    public Movie(Integer id, String title, String release, String desc, String movieBg) {
        this.id = id;
        this.title = title;
        this.release = release;
        this.desc = desc;
        this.movieBg = movieBg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMovieBg() {
        return movieBg;
    }

    public void setMovieBg(String movieBg) {
        this.movieBg = movieBg;
    }
}
