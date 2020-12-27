package com.example.android.movieadapter2.DetailTV;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.AcademyRepository1;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;

public class DetailViewModelT extends ViewModel {
    private Movie mCourse;
    private Integer courseId;
    private AcademyRepository1 academyRepository;

    public DetailViewModelT(AcademyRepository1 mAcademyRepository) {
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


