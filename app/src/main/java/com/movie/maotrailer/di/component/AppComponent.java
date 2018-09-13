package com.movie.maotrailer.di.component;

import android.app.Application;

import com.movie.maotrailer.MaoApp;
import com.movie.maotrailer.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class})
public interface AppComponent extends AndroidInjector<MaoApp> {

    @Override
    void inject(MaoApp instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }
}
