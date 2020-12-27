package com.example.android.movieadapter2;

import android.app.Application;
import android.util.Log;


import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class JsonHelper {

    private String result;
    private String done;

    public JsonHelper(Application application) {
//        ArrayList<MovieResponse> list = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + "f04bce2a28b277c0c4ee02124610fef5" + "&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    result = new String(responseBody);
                    done =result;


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }});
    }



            public List<MovieResponse> loadCourses() {

                ArrayList<MovieResponse> list = new ArrayList<>();

                try {
                    JSONObject responseObject = new JSONObject(done);

                    JSONArray listArray = responseObject.getJSONArray("results");
                    for (int i = 0; i < listArray.length(); i++) {
                        JSONObject course = listArray.getJSONObject(i);

                        Integer id = course.getInt("id");
                        String title = course.getString("title");
                        String description = course.getString("overview");
                        String date = course.getString("release_date");
                        String imagePath = course.getString("poster_path");

                        MovieResponse courseResponse = new MovieResponse(id, title, description, date, imagePath);
                        list.add(courseResponse);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return list;
            }

}






