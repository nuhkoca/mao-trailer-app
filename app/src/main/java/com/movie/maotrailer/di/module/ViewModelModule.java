package com.movie.maotrailer.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.movie.maotrailer.di.qualifier.ViewModelKey;
import com.movie.maotrailer.ui.detail.DetailViewModel;
import com.movie.maotrailer.ui.favorite.FavoriteViewModel;
import com.movie.maotrailer.ui.main.fragments.movie.MovieViewModel;
import com.movie.maotrailer.ui.main.fragments.tv.TvViewModel;
import com.movie.maotrailer.viewmodel.MaoViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel.class)
    abstract ViewModel bindsMovieViewModel(MovieViewModel movieViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TvViewModel.class)
    abstract ViewModel bindsTvViewModel(TvViewModel tvViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel.class)
    abstract ViewModel bindsDetailViewModel(DetailViewModel detailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel.class)
    abstract ViewModel bindsFavoriteViewModel(FavoriteViewModel favoriteViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsMaoViewModelFactory(MaoViewModelFactory maoViewModelFactory);
}
