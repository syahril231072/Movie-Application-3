package com.example.android.movieadapter2;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private AcademyRepository academyRepository = mock(AcademyRepository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(academyRepository);
    }

    @Test
    public void getCourses() {
        ArrayList<Movie> dummyCourses = FakeDataDummy.generateDummyCourses();

        MutableLiveData<List<Movie>> courses = new MutableLiveData<>();
        courses.setValue(dummyCourses);

        when(academyRepository.getAllCourses()).thenReturn(courses);

        Observer<List<Movie>> observer = mock(Observer.class);

        viewModel.getCourses().observeForever(observer);

        verify(observer).onChanged(dummyCourses);
    }

}