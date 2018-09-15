package com.movie.maotrailer.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public abstract class CastCardBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivCastPoster;

  @NonNull
  public final FrameLayout ivPosterLayout;

  @NonNull
  public final ProgressBar pbPoster;

  @NonNull
  public final TextView tvCastName;

  @NonNull
  public final TextView tvCrewJob;

  @Bindable
  protected String mProfileImage;

  @Bindable
  protected String mCastName;

  @Bindable
  protected String mCrewJob;

  protected CastCardBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView ivCastPoster, FrameLayout ivPosterLayout,
      ProgressBar pbPoster, TextView tvCastName, TextView tvCrewJob) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivCastPoster = ivCastPoster;
    this.ivPosterLayout = ivPosterLayout;
    this.pbPoster = pbPoster;
    this.tvCastName = tvCastName;
    this.tvCrewJob = tvCrewJob;
  }

  public abstract void setProfileImage(@Nullable String profileImage);

  @Nullable
  public String getProfileImage() {
    return mProfileImage;
  }

  public abstract void setCastName(@Nullable String castName);

  @Nullable
  public String getCastName() {
    return mCastName;
  }

  public abstract void setCrewJob(@Nullable String crewJob);

  @Nullable
  public String getCrewJob() {
    return mCrewJob;
  }

  @NonNull
  public static CastCardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CastCardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CastCardBinding>inflate(inflater, com.movie.maotrailer.R.layout.cast_card, root, attachToRoot, component);
  }

  @Nullable
  public static CastCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CastCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CastCardBinding>inflate(inflater, com.movie.maotrailer.R.layout.cast_card, null, false, component);
  }

  @NonNull
  public static CastCardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CastCardBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (CastCardBinding)bind(component, view, com.movie.maotrailer.R.layout.cast_card);
  }
}
