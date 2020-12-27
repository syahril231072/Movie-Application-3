package com.example.android.movieadapter2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;

import java.util.List;


public class MovieViewModel extends ViewModel {
    private AcademyRepository academyRepository;

    public MovieViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    LiveData<List<Movie>> getCourses() {
        return academyRepository.getAllCourses();
    }
}


