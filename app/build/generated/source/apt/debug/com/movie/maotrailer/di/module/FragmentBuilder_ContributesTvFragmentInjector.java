package com.movie.maotrailer.di.module;

import android.support.v4.app.Fragment;
import com.movie.maotrailer.ui.main.fragments.tv.TvFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = FragmentBuilder_ContributesTvFragmentInjector.TvFragmentSubcomponent.class)
public abstract class FragmentBuilder_ContributesTvFragmentInjector {
  private FragmentBuilder_ContributesTvFragmentInjector() {}

  @Binds
  @IntoMap
  @FragmentKey(TvFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      TvFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface TvFragmentSubcomponent extends AndroidInjector<TvFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TvFragment> {}
  }
}
