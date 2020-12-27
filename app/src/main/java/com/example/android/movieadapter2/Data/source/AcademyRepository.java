package com.example.android.movieadapter2.Data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository;
import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;
import com.example.android.movieadapter2.JsonHelper;

import java.util.ArrayList;
import java.util.List;

public class AcademyRepository implements AcademyDataSource {

    private volatile static AcademyRepository INSTANCE = null;

    private final RemoteRepository remoteRepository;

    private AcademyRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static AcademyRepository getInstance( RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (AcademyRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AcademyRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<Movie>> getAllCourses() {
        MutableLiveData<List<Movie>> courseResults = new MutableLiveData<>();



        remoteRepository.getAllCourses(new RemoteRepository.LoadCoursesCallback() {


            @Override
            public void onAllCoursesReceived(List<MovieResponse> courseResponses) {

                ArrayList<Movie> courseList = new ArrayList<>();
                for (int i = 0; i < courseResponses.size(); i++) {
                    MovieResponse response = courseResponses.get(i);
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
    public LiveData<Movie> getCourseWithModules(Integer courseId) {
        MutableLiveData<Movie> courseResult = new MutableLiveData<>();

        remoteRepository.getAllCourses(new RemoteRepository.LoadCoursesCallback() {
            @Override
            public void onAllCoursesReceived(List<MovieResponse> courseResponses) {
                for (int i = 0; i < courseResponses.size(); i++) {
                    MovieResponse response = courseResponses.get(i);
                    if (response.getId().equals(courseId)) {
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

