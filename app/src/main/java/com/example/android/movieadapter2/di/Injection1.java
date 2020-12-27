package com.example.android.movieadapter2.di;

import android.app.Application;

import com.example.android.movieadapter2.Data.source.AcademyRepository;
import com.example.android.movieadapter2.Data.source.AcademyRepository1;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository;
import com.example.android.movieadapter2.Data.source.remote.RemoteRepository1;
import com.example.android.movieadapter2.JsonHelper;
import com.example.android.movieadapter2.JsonHelper1;


public class Injection1 {
    public static AcademyRepository1 provideRepository(Application application) {

        RemoteRepository1 remoteRepository = RemoteRepository1.getInstance(new JsonHelper1(application));

        return AcademyRepository1.getInstance(remoteRepository);
    }
}
