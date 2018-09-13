package com.movie.maotrailer.di.module;

import android.support.v4.app.Fragment;
import com.movie.maotrailer.ui.main.fragments.movie.MovieFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBuilder_ContributesMovieFragmentInjector.MovieFragmentSubcomponent.class
)
public abstract class FragmentBuilder_ContributesMovieFragmentInjector {
  private FragmentBuilder_ContributesMovieFragmentInjector() {}

  @Binds
  @IntoMap
  @FragmentKey(MovieFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      MovieFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface MovieFragmentSubcomponent extends AndroidInjector<MovieFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieFragment> {}
  }
}
