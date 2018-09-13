package com.movie.maotrailer.di.module;

import android.app.Activity;
import com.movie.maotrailer.ui.detail.DetailActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBuilder_ContributesDetailActivityInjector.DetailActivitySubcomponent.class
)
public abstract class ActivityBuilder_ContributesDetailActivityInjector {
  private ActivityBuilder_ContributesDetailActivityInjector() {}

  @Binds
  @IntoMap
  @ActivityKey(DetailActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      DetailActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface DetailActivitySubcomponent extends AndroidInjector<DetailActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailActivity> {}
  }
}
