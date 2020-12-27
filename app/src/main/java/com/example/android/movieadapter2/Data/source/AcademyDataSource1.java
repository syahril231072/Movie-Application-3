package com.example.android.movieadapter2.Data.source;


import androidx.lifecycle.LiveData;

import com.example.android.movieadapter2.Data.source.local.entity.Movie;

import java.util.List;

public interface AcademyDataSource1 {

    LiveData<List<Movie>> getAllCourses();

    LiveData<Movie> getCourseWithModules(Integer courseId);

    }