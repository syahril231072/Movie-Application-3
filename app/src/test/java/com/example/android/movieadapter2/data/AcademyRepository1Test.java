package com.example.android.movieadapter2.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository1;
import com.example.android.movieadapter2.Data.source.remote.response.MovieResponse;
import com.example.android.movieadapter2.Data.source.remote.response.TVShow;
import com.example.android.movieadapter2.utils.FakeDataDummy;
import com.example.android.movieadapter2.utils.FakeDataDummy1;
import com.example.android.movieadapter2.utils.LiveDataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AcademyRepository1Test {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteRepository1 remote = Mockito.mock(RemoteRepository1.class);
    private FakeAcademyRepository1 academyRepository = new FakeAcademyRepository1(remote);

    private ArrayList<TVShow> courseResponses = FakeDataDummy1.generateRemoteDummyCourses();
    private Integer courseId = courseResponses.get(0).getId();

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getAllCourses() {

        doAnswer(invocation -> {
            ((RemoteRepository1.LoadCoursesCallback) invocation.getArguments()[0])
                    .onAllCoursesReceived(courseResponses);
            return null;
        }).when(remote).getAllCourses(any(RemoteRepository1.LoadCoursesCallback.class));

        List<Movie> result = LiveDataTestUtil.getValue(academyRepository.getAllCourses());

        verify(remote, times(1)).getAllCourses(any(RemoteRepository1.LoadCoursesCallback.class));

        assertNotNull(result);
        assertEquals(courseResponses.size(), result.size());
    }


}