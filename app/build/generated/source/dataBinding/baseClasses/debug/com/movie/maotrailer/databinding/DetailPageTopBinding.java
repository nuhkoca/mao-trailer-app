package com.movie.maotrailer.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.movie.maotrailer.data.remote.item.Results;

public abstract class DetailPageTopBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivPoster;

  @NonNull
  public final AppCompatRatingBar rbAverage;

  @NonNull
  public final TextView tvAverage;

  @NonNull
  public final TextView tvGenre;

  @Bindable
  protected Results mResult;

  protected DetailPageTopBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView ivPoster, AppCompatRatingBar rbAverage, TextView tvAverage,
      TextView tvGenre) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivPoster = ivPoster;
    this.rbAverage = rbAverage;
    this.tvAverage = tvAverage;
    this.tvGenre = tvGenre;
  }

  public abstract void setResult(@Nullable Results result);

  @Nullable
  public Results getResult() {
    return mResult;
  }

  @NonNull
  public static DetailPageTopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DetailPageTopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DetailPageTopBinding>inflate(inflater, com.movie.maotrailer.R.layout.detail_page_top, root, attachToRoot, component);
  }

  @Nullable
  public static DetailPageTopBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DetailPageTopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DetailPageTopBinding>inflate(inflater, com.movie.maotrailer.R.layout.detail_page_top, null, false, component);
  }

  @NonNull
  public static DetailPageTopBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DetailPageTopBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DetailPageTopBinding)bind(component, view, com.movie.maotrailer.R.layout.detail_page_top);
  }
}
