package com.example.android.movieadapter2.Data.source;


import androidx.lifecycle.LiveData;

import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;

import java.util.List;

public interface AcademyDataSource {

    LiveData<List<Movie>> getAllCourses();

    LiveData<Movie> getCourseWithModules(Integer courseId);

    }