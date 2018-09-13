package com.movie.maotrailer.di.module;

import android.support.v4.app.Fragment;
import com.movie.maotrailer.ui.main.fragments.profile.ProfileFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentBuilder_ContributesProfileFragmentInjector.ProfileFragmentSubcomponent.class
)
public abstract class FragmentBuilder_ContributesProfileFragmentInjector {
  private FragmentBuilder_ContributesProfileFragmentInjector() {}

  @Binds
  @IntoMap
  @FragmentKey(ProfileFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ProfileFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ProfileFragmentSubcomponent extends AndroidInjector<ProfileFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProfileFragment> {}
  }
}
