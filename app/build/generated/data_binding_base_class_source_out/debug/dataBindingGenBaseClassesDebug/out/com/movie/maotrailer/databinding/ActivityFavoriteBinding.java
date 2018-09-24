package com.movie.maotrailer.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public abstract class ActivityFavoriteBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clFavorite;

  @NonNull
  public final ProgressBar pbFavorite;

  @NonNull
  public final RecyclerView rvFavorite;

  @NonNull
  public final TextView tvErrButtonMutual;

  @NonNull
  public final TextView tvErrTextFavorite;

  protected ActivityFavoriteBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clFavorite, ProgressBar pbFavorite,
      RecyclerView rvFavorite, TextView tvErrButtonMutual, TextView tvErrTextFavorite) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clFavorite = clFavorite;
    this.pbFavorite = pbFavorite;
    this.rvFavorite = rvFavorite;
    this.tvErrButtonMutual = tvErrButtonMutual;
    this.tvErrTextFavorite = tvErrTextFavorite;
  }

  @NonNull
  public static ActivityFavoriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFavoriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFavoriteBinding>inflate(inflater, com.movie.maotrailer.R.layout.activity_favorite, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFavoriteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFavoriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFavoriteBinding>inflate(inflater, com.movie.maotrailer.R.layout.activity_favorite, null, false, component);
  }

  public static ActivityFavoriteBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFavoriteBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFavoriteBinding)bind(component, view, com.movie.maotrailer.R.layout.activity_favorite);
  }
}
