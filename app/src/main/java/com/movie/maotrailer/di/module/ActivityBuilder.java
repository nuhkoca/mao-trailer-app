package com.movie.maotrailer.di.module;

import com.movie.maotrailer.ui.detail.DetailActivity;
import com.movie.maotrailer.ui.favorite.FavoriteActivity;
import com.movie.maotrailer.ui.main.MainActivity;
import com.movie.maotrailer.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivityInjector();

    @ContributesAndroidInjector
    abstract SplashActivity contributesSplashActivityInjector();

    @ContributesAndroidInjector
    abstract DetailActivity contributesDetailActivityInjector();

    @ContributesAndroidInjector
    abstract FavoriteActivity contributesFavoriteActivityInjector();
}
