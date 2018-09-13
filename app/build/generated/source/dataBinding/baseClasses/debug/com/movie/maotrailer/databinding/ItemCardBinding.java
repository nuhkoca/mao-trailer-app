package com.movie.maotrailer.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.movie.maotrailer.callback.IItemClickListener;
import com.movie.maotrailer.data.remote.item.Results;

public abstract class ItemCardBinding extends ViewDataBinding {
  @NonNull
  public final CardView cvMain;

  @NonNull
  public final ImageView ivPoster;

  @NonNull
  public final TextView tvDate;

  @Bindable
  protected Results mResult;

  @Bindable
  protected IItemClickListener mItemClickListener;

  protected ItemCardBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView cvMain, ImageView ivPoster, TextView tvDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cvMain = cvMain;
    this.ivPoster = ivPoster;
    this.tvDate = tvDate;
  }

  public abstract void setResult(@Nullable Results result);

  @Nullable
  public Results getResult() {
    return mResult;
  }

  public abstract void setItemClickListener(@Nullable IItemClickListener itemClickListener);

  @Nullable
  public IItemClickListener getItemClickListener() {
    return mItemClickListener;
  }

  @NonNull
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemCardBinding>inflate(inflater, com.movie.maotrailer.R.layout.item_card, root, attachToRoot, component);
  }

  @Nullable
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemCardBinding>inflate(inflater, com.movie.maotrailer.R.layout.item_card, null, false, component);
  }

  @NonNull
  public static ItemCardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemCardBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (ItemCardBinding)bind(component, view, com.movie.maotrailer.R.layout.item_card);
  }
}
