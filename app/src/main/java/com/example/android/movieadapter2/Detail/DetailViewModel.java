package com.example.android.movieadapter2.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;

import java.util.List;

public class DetailViewModel extends ViewModel {
    private Movie mCourse;
    private Integer courseId;
    private AcademyRepository academyRepository;

    public DetailViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public LiveData<Movie> getCourse() {
        return academyRepository.getCourseWithModules(courseId);
    }



    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}


