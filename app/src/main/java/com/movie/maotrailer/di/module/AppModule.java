package com.movie.maotrailer.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.movie.maotrailer.helper.Constants;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = {ActivityBuilder.class, FragmentBuilder.class, ContextModule.class, NetModule.class, ViewModelModule.class, RoomModule.class})
public class AppModule {

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    SharedPreferences provideSharedPreferences(Application application){
        return application.getApplicationContext().getSharedPreferences(Constants.MAO_PREFEENCE_NAME, Context.MODE_PRIVATE);
    }
}
