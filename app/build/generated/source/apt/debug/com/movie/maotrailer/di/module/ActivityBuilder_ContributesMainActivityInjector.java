package com.movie.maotrailer.di.module;

import android.app.Activity;
import com.movie.maotrailer.ui.main.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBuilder_ContributesMainActivityInjector.MainActivitySubcomponent.class
)
public abstract class ActivityBuilder_ContributesMainActivityInjector {
  private ActivityBuilder_ContributesMainActivityInjector() {}

  @Binds
  @IntoMap
  @ActivityKey(MainActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
  }
}
