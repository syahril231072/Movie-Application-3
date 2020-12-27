package com.example.android.movieadapter2.di;

import android.app.Application;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository;
import com.example.android.movieadapter2.JsonHelper;


public class Injection {
    public static AcademyRepository provideRepository(Application application) {

        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));

        return AcademyRepository.getInstance(remoteRepository);
    }
}
