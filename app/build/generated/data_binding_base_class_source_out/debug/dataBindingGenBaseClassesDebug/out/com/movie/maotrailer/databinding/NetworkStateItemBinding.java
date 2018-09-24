package com.movie.maotrailer.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.movie.maotrailer.callback.IRetryListener;

public abstract class NetworkStateItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clNetwork;

  @NonNull
  public final ProgressBar pbNetwork;

  @NonNull
  public final TextView tvNetworkErr;

  @NonNull
  public final TextView tvNetworkErrButton;

  @Bindable
  protected IRetryListener mRetryListener;

  protected NetworkStateItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clNetwork, ProgressBar pbNetwork,
      TextView tvNetworkErr, TextView tvNetworkErrButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clNetwork = clNetwork;
    this.pbNetwork = pbNetwork;
    this.tvNetworkErr = tvNetworkErr;
    this.tvNetworkErrButton = tvNetworkErrButton;
  }

  public abstract void setRetryListener(@Nullable IRetryListener retryListener);

  @Nullable
  public IRetryListener getRetryListener() {
    return mRetryListener;
  }

  @NonNull
  public static NetworkStateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static NetworkStateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<NetworkStateItemBinding>inflate(inflater, com.movie.maotrailer.R.layout.network_state_item, root, attachToRoot, component);
  }

  @NonNull
  public static NetworkStateItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static NetworkStateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<NetworkStateItemBinding>inflate(inflater, com.movie.maotrailer.R.layout.network_state_item, null, false, component);
  }

  public static NetworkStateItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static NetworkStateItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (NetworkStateItemBinding)bind(component, view, com.movie.maotrailer.R.layout.network_state_item);
  }
}
