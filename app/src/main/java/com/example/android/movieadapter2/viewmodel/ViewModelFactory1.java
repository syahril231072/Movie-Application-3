package com.example.android.movieadapter2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.AcademyRepository1;
import com.example.android.movieadapter2.Detail.DetailViewModel;
import com.example.android.movieadapter2.DetailTV.DetailViewModelT;
import com.example.android.movieadapter2.MovieViewModel;
import com.example.android.movieadapter2.TVShowViewModel;
import com.example.android.movieadapter2.di.Injection;
import com.example.android.movieadapter2.di.Injection1;


public class ViewModelFactory1 extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory1 INSTANCE;

    private final AcademyRepository1 mAcademyRepository;

    private ViewModelFactory1(AcademyRepository1 academyRepository) {
        mAcademyRepository = academyRepository;
    }

    public static ViewModelFactory1 getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory1.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory1(Injection1.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(TVShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TVShowViewModel(mAcademyRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModelT.class)) {
            //noinspection unchecked
            return (T) new DetailViewModelT(mAcademyRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
