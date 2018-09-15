package com.movie.maotrailer.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.movie.maotrailer.data.remote.item.Results;

public abstract class ActivityDetailBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout aplDetail;

  @NonNull
  public final CoordinatorLayout clDetail;

  @NonNull
  public final CollapsingToolbarLayout ctlDetail;

  @NonNull
  public final CardView cvCastCrew;

  @NonNull
  public final ImageButton ibPlay;

  @NonNull
  public final DetailPageTopBinding lDetailPageTop;

  @NonNull
  public final NestedScrollView nsvDetail;

  @NonNull
  public final ProgressBar pbCastCrew;

  @NonNull
  public final RecyclerView rvCast;

  @NonNull
  public final Toolbar toolbarDetail;

  @NonNull
  public final TextView tvCastCrewHeader;

  @Bindable
  protected Results mResult;

  protected ActivityDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, AppBarLayout aplDetail, CoordinatorLayout clDetail,
      CollapsingToolbarLayout ctlDetail, CardView cvCastCrew, ImageButton ibPlay,
      DetailPageTopBinding lDetailPageTop, NestedScrollView nsvDetail, ProgressBar pbCastCrew,
      RecyclerView rvCast, Toolbar toolbarDetail, TextView tvCastCrewHeader) {
    super(_bindingComponent, _root, _localFieldCount);
    this.aplDetail = aplDetail;
    this.clDetail = clDetail;
    this.ctlDetail = ctlDetail;
    this.cvCastCrew = cvCastCrew;
    this.ibPlay = ibPlay;
    this.lDetailPageTop = lDetailPageTop;
    setContainedBinding(this.lDetailPageTop);;
    this.nsvDetail = nsvDetail;
    this.pbCastCrew = pbCastCrew;
    this.rvCast = rvCast;
    this.toolbarDetail = toolbarDetail;
    this.tvCastCrewHeader = tvCastCrewHeader;
  }

  public abstract void setResult(@Nullable Results result);

  @Nullable
  public Results getResult() {
    return mResult;
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.movie.maotrailer.R.layout.activity_detail, root, attachToRoot, component);
  }

  @Nullable
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.movie.maotrailer.R.layout.activity_detail, null, false, component);
  }

  @NonNull
  public static ActivityDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDetailBinding)bind(component, view, com.movie.maotrailer.R.layout.activity_detail);
  }
}
