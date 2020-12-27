package com.example.android.movieadapter2.Data.source.remote;

import android.os.Handler;


import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;
import com.example.android.movieadapter2.EspressoIdlingResource;
import com.example.android.movieadapter2.JsonHelper;

import java.util.List;

public class RemoteRepository {

    private static RemoteRepository INSTANCE;
    private final long SERVICE_LATENCY_IN_MILLIS = 5000;
    private JsonHelper jsonHelper;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
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

        void onAllCoursesReceived(List<MovieResponse> courseResponses);


        void onDataNotAvailable();
    }


}

