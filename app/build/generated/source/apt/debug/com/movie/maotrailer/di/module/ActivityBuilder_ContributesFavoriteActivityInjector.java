package com.movie.maotrailer.di.module;

import android.app.Activity;
import com.movie.maotrailer.ui.favorite.FavoriteActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuilder_ContributesFavoriteActivityInjector.FavoriteActivitySubcomponent.class
)
public abstract class ActivityBuilder_ContributesFavoriteActivityInjector {
  private ActivityBuilder_ContributesFavoriteActivityInjector() {}

  @Binds
  @IntoMap
  @ActivityKey(FavoriteActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      FavoriteActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface FavoriteActivitySubcomponent extends AndroidInjector<FavoriteActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FavoriteActivity> {}
  }
}
