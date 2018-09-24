package com.movie.maotrailer.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public abstract class FragmentProfileBinding extends ViewDataBinding {
  @NonNull
  public final Button btnFavorites;

  @NonNull
  public final TextView tvProfile;

  protected FragmentProfileBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnFavorites, TextView tvProfile) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnFavorites = btnFavorites;
    this.tvProfile = tvProfile;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProfileBinding>inflate(inflater, com.movie.maotrailer.R.layout.fragment_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProfileBinding>inflate(inflater, com.movie.maotrailer.R.layout.fragment_profile, null, false, component);
  }

  public static FragmentProfileBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentProfileBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentProfileBinding)bind(component, view, com.movie.maotrailer.R.layout.fragment_profile);
  }
}
