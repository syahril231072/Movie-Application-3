package com.example.android.movieadapter2.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.movieadapter2.Data.source.AcademyDataSource;
import com.example.android.movieadapter2.Data.source.AcademyDataSource1;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository1;
import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;
import com.example.android.movieadapter2.Data.source.remote.response.TVShow;

import java.util.ArrayList;
import java.util.List;

public class FakeAcademyRepository1 implements AcademyDataSource1 {

    private volatile static FakeAcademyRepository1 INSTANCE = null;

    private final RemoteRepository1 remoteRepository;

    FakeAcademyRepository1(@NonNull RemoteRepository1 remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static FakeAcademyRepository1 getInstance(RemoteRepository1 remoteData) {
        if (INSTANCE == null) {
            synchronized (FakeAcademyRepository1.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeAcademyRepository1(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<Movie>> getAllCourses() {
        MutableLiveData<List<Movie>> courseResults = new MutableLiveData<>();

        remoteRepository.getAllCourses(new RemoteRepository1.LoadCoursesCallback() {
            @Override
            public void onAllCoursesReceived(List<TVShow> courseResponses) {
                ArrayList<Movie> courseList = new ArrayList<>();
                for (int i = 0; i < courseResponses.size(); i++) {
                    TVShow response = courseResponses.get(i);
                    Movie course = new Movie(response.getId(),
                            response.getTitle(),
                            response.getDesc(),
                            response.getRelease(),
                            response.getMovieBg());

                    courseList.add(course);
                }
                courseResults.postValue(courseList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return courseResults;
    }



    // Pada metode ini di modul selanjutnya akan mengembalikan kelas POJO baru, gabungan antara course dengan module-nya.
    @Override
    public LiveData<Movie> getCourseWithModules(final Integer Id) {
        MutableLiveData<Movie> courseResult = new MutableLiveData<>();

        remoteRepository.getAllCourses(new RemoteRepository1.LoadCoursesCallback() {
            @Override
            public void onAllCoursesReceived(List<TVShow> courseResponses) {
                for (int i = 0; i < courseResponses.size(); i++) {
                    TVShow response = courseResponses.get(i);
                    if (response.getId().equals(Id)) {
                        Movie course = new Movie(response.getId(),
                                response.getTitle(),
                                response.getDesc(),
                                response.getRelease(),
                                response.getMovieBg());
                        courseResult.postValue(course);
                    }
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return courseResult;
    }


}

