package com.movie.maotrailer.di.module;

import android.app.Activity;
import com.movie.maotrailer.ui.splash.SplashActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBuilder_ContributesSplashActivityInjector.SplashActivitySubcomponent.class
)
public abstract class ActivityBuilder_ContributesSplashActivityInjector {
  private ActivityBuilder_ContributesSplashActivityInjector() {}

  @Binds
  @IntoMap
  @ActivityKey(SplashActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      SplashActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface SplashActivitySubcomponent extends AndroidInjector<SplashActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SplashActivity> {}
  }
}
