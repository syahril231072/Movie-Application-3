package com.example.android.movieadapter2.DetailTV;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.request.RequestOptions;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.GlideApp;
import com.example.android.movieadapter2.R;
import com.example.android.movieadapter2.viewmodel.ViewModelFactory1;

public class DetailActivityT extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private DetailViewModelT viewModel;
    private ProgressBar progressBar;
    TextView titleObject;
    TextView descObject;
    TextView releaseObject;
    ImageView movieBgObject;
    @NonNull
    private static DetailViewModelT obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory1 factory = ViewModelFactory1.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailViewModelT.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        viewModel = obtainViewModel(this);

        progressBar = findViewById(R.id.progressDetailMovie);

        progressBar.setVisibility(View.VISIBLE);
        titleObject = findViewById(R.id.titleDetail);
        descObject = findViewById(R.id.descDetail);
        releaseObject = findViewById(R.id.releaseDetail);
        movieBgObject = findViewById(R.id.movieImageDetail);
        progressBar.setVisibility(View.VISIBLE);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Integer courseId = extras.getInt(EXTRA_MOVIE);
            if (courseId != null) {
                viewModel.setCourseId(courseId);

            }
        }

        viewModel.getCourse().observe(this, courseEntity -> {
            if (courseEntity != null) {
                populateCourse(courseEntity);
                showLoading(false);
            }
        });



    }

    private void populateCourse(Movie courseEntity) {
        titleObject.setText(courseEntity.getTitle());
        descObject.setText(courseEntity.getDesc());
        releaseObject.setText(String.format(courseEntity.getRelease()));
        String url_image = "https://image.tmdb.org/t/p/w185" + courseEntity.getMovieBg();
        GlideApp.with(getApplicationContext())
                .load(url_image)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(movieBgObject);
        progressBar.setVisibility(View.INVISIBLE);

    }

    private void showLoading(Boolean state) {
        if (false) {
            progressBar.setVisibility(View.VISIBLE);


        } else {
            progressBar.setVisibility(View.GONE);

        }
    }



}
