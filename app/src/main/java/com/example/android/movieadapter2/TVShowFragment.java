package com.example.android.movieadapter2;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.viewmodel.ViewModelFactory;
import com.example.android.movieadapter2.viewmodel.ViewModelFactory1;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {
    private RecyclerView rvCourse;
    private ProgressBar progressBar;
    private ListTVShowAdapter academyAdapter;
    private TVShowViewModel viewModel;
    private List<Movie> courses;

    public TVShowFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance() {
        return new TVShowFragment();
    }

    @NonNull
    private static TVShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory1 factory = ViewModelFactory1.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TVShowViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCourse = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            viewModel = obtainViewModel(getActivity());

            academyAdapter = new ListTVShowAdapter(getActivity());

            viewModel.getCourses().observe(this, courses -> {
                progressBar.setVisibility(View.GONE);
                academyAdapter.setListCourses(courses);
                academyAdapter.notifyDataSetChanged();
            });

            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(academyAdapter);
        }
    }


}

