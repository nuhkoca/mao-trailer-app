package com.movie.maotrailer.di.module;

import com.movie.maotrailer.ui.main.fragments.movie.MovieFragment;
import com.movie.maotrailer.ui.main.fragments.profile.ProfileFragment;
import com.movie.maotrailer.ui.main.fragments.tv.TvFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract MovieFragment contributesMovieFragmentInjector();

    @ContributesAndroidInjector
    abstract TvFragment contributesTvFragmentInjector();

    @ContributesAndroidInjector
    abstract ProfileFragment contributesProfileFragmentInjector();
}
