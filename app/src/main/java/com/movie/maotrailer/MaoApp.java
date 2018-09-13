package com.movie.maotrailer;

import com.movie.maotrailer.di.component.AppComponent;
import com.movie.maotrailer.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MaoApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

        return appComponent;
    }
}
