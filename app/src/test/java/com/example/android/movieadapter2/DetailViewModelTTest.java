package com.example.android.movieadapter2;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.AcademyRepository1;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Detail.DetailViewModel;
import com.example.android.movieadapter2.DetailTV.DetailViewModelT;
import com.example.android.movieadapter2.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailViewModelT viewModel;
    private AcademyRepository1 academyRepository = mock(AcademyRepository1.class);
    private Movie dummyCourse = FakeDataDummy.generateDummyCourses().get(0);
    private Integer courseId = dummyCourse.getId();

    @Before
    public void setUp() {
        viewModel = new DetailViewModelT(academyRepository);
        viewModel.setCourseId(courseId);
    }

    @Test
    public void getCourse() {
        MutableLiveData<Movie> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(dummyCourse);

        when(academyRepository.getCourseWithModules(courseId)).thenReturn(courseEntities);

        Observer<Movie> observer = mock(Observer.class);

        viewModel.getCourse().observeForever(observer);

        verify(observer).onChanged(dummyCourse);
    }
}