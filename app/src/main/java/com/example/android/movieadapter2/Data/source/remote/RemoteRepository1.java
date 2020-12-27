package com.example.android.movieadapter2.Data.source.remote;

import android.os.Handler;

import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;
import com.example.android.movieadapter2.Data.source.remote.response.TVShow;
import com.example.android.movieadapter2.EspressoIdlingResource;
import com.example.android.movieadapter2.JsonHelper;
import com.example.android.movieadapter2.JsonHelper1;

import java.util.List;

public class RemoteRepository1 {

    private static RemoteRepository1 INSTANCE;
    private final long SERVICE_LATENCY_IN_MILLIS = 5000;
    private JsonHelper1 jsonHelper;

    private RemoteRepository1(JsonHelper1 jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository1 getInstance(JsonHelper1 helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository1(helper);
        }
        return INSTANCE;
    }

    public void getAllCourses(LoadCoursesCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onAllCoursesReceived(jsonHelper.loadCourses());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }



    public interface LoadCoursesCallback {
        void onAllCoursesReceived(List<TVShow> courseResponses);


        void onDataNotAvailable();
    }


}

