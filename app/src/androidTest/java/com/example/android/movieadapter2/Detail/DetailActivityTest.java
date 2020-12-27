package com.example.android.movieadapter2.Detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.EspressoIdlingResource;
import com.example.android.movieadapter2.R;
import com.example.android.movieadapter2.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTest {

    private Movie dummyCourse = FakeDataDummy.generateDummyCourses().get(0);

    @Rule
    public ActivityTestRule<DetailActivity> activityRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailActivity.class);
            result.putExtra(DetailActivity.EXTRA_MOVIE, dummyCourse.getId());
            return result;
        }
    };
    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadCourse() {

        onView(withId(R.id.titleDetail)).check(matches(isDisplayed()));
        onView(withId(R.id.titleDetail)).check(matches(withText(dummyCourse.getTitle())));
        onView(withId(R.id.descDetail)).check(matches(isDisplayed()));
        onView(withId(R.id.descDetail)).check(matches(withText(String.format(dummyCourse.getDesc()))));
    }

}