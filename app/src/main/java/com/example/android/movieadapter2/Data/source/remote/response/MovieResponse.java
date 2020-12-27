package com.example.android.movieadapter2.Data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class MovieResponse implements Parcelable {


    private Integer id;
    private String title;
    private String release;
    private String desc;
    private String movieBg;

    public MovieResponse(Integer id, String title, String release, String desc, String movieBg) {
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


    public MovieResponse(JSONObject object) {
        try {

            String title = object.getString("title");

            String overview = object.getString("overview");
            String release_date = object.getString("release_date");
            String poster_path = object.getString("poster_path");

            this.id = object.getInt("id");
            this.title = title;
            this.desc = overview;
            this.release = release_date;
            this.movieBg = poster_path;


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeString(this.release);
        dest.writeString(this.desc);
        dest.writeString(this.movieBg);
    }

    protected MovieResponse(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.release = in.readString();
        this.desc = in.readString();
        this.movieBg = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel source) {
            return new MovieResponse(source);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}
