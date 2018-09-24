package com.movie.maotrailer.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public abstract class FragmentMutualBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar pbMutual;

  @NonNull
  public final RecyclerView rvMutual;

  @NonNull
  public final TextView tvErrButtonMutual;

  @NonNull
  public final TextView tvErrTextMutual;

  protected FragmentMutualBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ProgressBar pbMutual, RecyclerView rvMutual, TextView tvErrButtonMutual,
      TextView tvErrTextMutual) {
    super(_bindingComponent, _root, _localFieldCount);
    this.pbMutual = pbMutual;
    this.rvMutual = rvMutual;
    this.tvErrButtonMutual = tvErrButtonMutual;
    this.tvErrTextMutual = tvErrTextMutual;
  }

  @NonNull
  public static FragmentMutualBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMutualBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMutualBinding>inflate(inflater, com.movie.maotrailer.R.layout.fragment_mutual, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMutualBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMutualBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMutualBinding>inflate(inflater, com.movie.maotrailer.R.layout.fragment_mutual, null, false, component);
  }

  public static FragmentMutualBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMutualBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMutualBinding)bind(component, view, com.movie.maotrailer.R.layout.fragment_mutual);
  }
}
