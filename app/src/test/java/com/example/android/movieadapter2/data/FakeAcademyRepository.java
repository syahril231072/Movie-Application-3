package com.example.android.movieadapter2.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.movieadapter2.Data.source.AcademyDataSource;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository;
import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeAcademyRepository implements AcademyDataSource {

    private volatile static FakeAcademyRepository INSTANCE = null;

    private final RemoteRepository remoteRepository;

    FakeAcademyRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static FakeAcademyRepository getInstance(RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (FakeAcademyRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeAcademyRepository(remoteData);
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
    public LiveData<Movie> getCourseWithModules(final Integer Id) {
        MutableLiveData<Movie> courseResult = new MutableLiveData<>();

        remoteRepository.getAllCourses(new RemoteRepository.LoadCoursesCallback() {
            @Override
            public void onAllCoursesReceived(List<MovieResponse> courseResponses) {
                for (int i = 0; i < courseResponses.size(); i++) {
                    MovieResponse response = courseResponses.get(i);
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

