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
import com.movie.maotrailer.callback.IPopupMenuItemClickListener;
import com.movie.maotrailer.data.local.entity.FavoriteThings;

public abstract class FavoriteItemCardBinding extends ViewDataBinding {
  @NonNull
  public final CardView cvMain;

  @NonNull
  public final ImageView ivMore;

  @NonNull
  public final ImageView ivPoster;

  @NonNull
  public final TextView tvDate;

  @NonNull
  public final View vBg;

  @Bindable
  protected FavoriteThings mFavorite;

  @Bindable
  protected IPopupMenuItemClickListener mPopupClickListener;

  protected FavoriteItemCardBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView cvMain, ImageView ivMore, ImageView ivPoster, TextView tvDate,
      View vBg) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cvMain = cvMain;
    this.ivMore = ivMore;
    this.ivPoster = ivPoster;
    this.tvDate = tvDate;
    this.vBg = vBg;
  }

  public abstract void setFavorite(@Nullable FavoriteThings favorite);

  @Nullable
  public FavoriteThings getFavorite() {
    return mFavorite;
  }

  public abstract void setPopupClickListener(@Nullable IPopupMenuItemClickListener popupClickListener);

  @Nullable
  public IPopupMenuItemClickListener getPopupClickListener() {
    return mPopupClickListener;
  }

  @NonNull
  public static FavoriteItemCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FavoriteItemCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FavoriteItemCardBinding>inflate(inflater, com.movie.maotrailer.R.layout.favorite_item_card, root, attachToRoot, component);
  }

  @NonNull
  public static FavoriteItemCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FavoriteItemCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FavoriteItemCardBinding>inflate(inflater, com.movie.maotrailer.R.layout.favorite_item_card, null, false, component);
  }

  public static FavoriteItemCardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FavoriteItemCardBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FavoriteItemCardBinding)bind(component, view, com.movie.maotrailer.R.layout.favorite_item_card);
  }
}
