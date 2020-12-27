package com.example.android.movieadapter2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.AcademyRepository1;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;

import java.util.List;


public class TVShowViewModel extends ViewModel {
    private AcademyRepository1 academyRepository;

    public TVShowViewModel(AcademyRepository1 mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    LiveData<List<Movie>> getCourses() {
        return academyRepository.getAllCourses();
    }
}


