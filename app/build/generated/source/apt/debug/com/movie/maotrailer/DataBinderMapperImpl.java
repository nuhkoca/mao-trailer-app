package com.movie.maotrailer;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.movie.maotrailer.databinding.ActivityDetailBindingImpl;
import com.movie.maotrailer.databinding.ActivityFavoriteBindingImpl;
import com.movie.maotrailer.databinding.ActivityMainBindingImpl;
import com.movie.maotrailer.databinding.CastCardBindingImpl;
import com.movie.maotrailer.databinding.DetailPageTopBindingImpl;
import com.movie.maotrailer.databinding.FavoriteItemCardBindingImpl;
import com.movie.maotrailer.databinding.FragmentMutualBindingImpl;
import com.movie.maotrailer.databinding.FragmentProfileBindingImpl;
import com.movie.maotrailer.databinding.ItemCardBindingImpl;
import com.movie.maotrailer.databinding.NetworkStateItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_NETWORKSTATEITEM = 2;

  private static final int LAYOUT_FRAGMENTMUTUAL = 3;

  private static final int LAYOUT_CASTCARD = 4;

  private static final int LAYOUT_DETAILPAGETOP = 5;

  private static final int LAYOUT_FRAGMENTPROFILE = 6;

  private static final int LAYOUT_ACTIVITYFAVORITE = 7;

  private static final int LAYOUT_ITEMCARD = 8;

  private static final int LAYOUT_FAVORITEITEMCARD = 9;

  private static final int LAYOUT_ACTIVITYDETAIL = 10;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(10);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.network_state_item, LAYOUT_NETWORKSTATEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.fragment_mutual, LAYOUT_FRAGMENTMUTUAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.cast_card, LAYOUT_CASTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.detail_page_top, LAYOUT_DETAILPAGETOP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.activity_favorite, LAYOUT_ACTIVITYFAVORITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.item_card, LAYOUT_ITEMCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.favorite_item_card, LAYOUT_FAVORITEITEMCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.activity_detail, LAYOUT_ACTIVITYDETAIL);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_NETWORKSTATEITEM: {
          if ("layout/network_state_item_0".equals(tag)) {
            return new NetworkStateItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for network_state_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMUTUAL: {
          if ("layout/fragment_mutual_0".equals(tag)) {
            return new FragmentMutualBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_mutual is invalid. Received: " + tag);
        }
        case  LAYOUT_CASTCARD: {
          if ("layout/cast_card_0".equals(tag)) {
            return new CastCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cast_card is invalid. Received: " + tag);
        }
        case  LAYOUT_DETAILPAGETOP: {
          if ("layout/detail_page_top_0".equals(tag)) {
            return new DetailPageTopBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for detail_page_top is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFAVORITE: {
          if ("layout/activity_favorite_0".equals(tag)) {
            return new ActivityFavoriteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_favorite is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCARD: {
          if ("layout/item_card_0".equals(tag)) {
            return new ItemCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_card is invalid. Received: " + tag);
        }
        case  LAYOUT_FAVORITEITEMCARD: {
          if ("layout/favorite_item_card_0".equals(tag)) {
            return new FavoriteItemCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for favorite_item_card is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDETAIL: {
          if ("layout/activity_detail_0".equals(tag)) {
            return new ActivityDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_detail is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    final int code = tag.hashCode();
    switch(code) {
      case 423753077: {
        if(tag.equals("layout/activity_main_0")) {
          return R.layout.activity_main;
        }
        break;
      }
      case -909487704: {
        if(tag.equals("layout/network_state_item_0")) {
          return R.layout.network_state_item;
        }
        break;
      }
      case -1653833681: {
        if(tag.equals("layout/fragment_mutual_0")) {
          return R.layout.fragment_mutual;
        }
        break;
      }
      case -363980708: {
        if(tag.equals("layout/cast_card_0")) {
          return R.layout.cast_card;
        }
        break;
      }
      case 537559839: {
        if(tag.equals("layout/detail_page_top_0")) {
          return R.layout.detail_page_top;
        }
        break;
      }
      case 1940278000: {
        if(tag.equals("layout/fragment_profile_0")) {
          return R.layout.fragment_profile;
        }
        break;
      }
      case 80293656: {
        if(tag.equals("layout/activity_favorite_0")) {
          return R.layout.activity_favorite;
        }
        break;
      }
      case -1774755320: {
        if(tag.equals("layout/item_card_0")) {
          return R.layout.item_card;
        }
        break;
      }
      case 54963471: {
        if(tag.equals("layout/favorite_item_card_0")) {
          return R.layout.favorite_item_card;
        }
        break;
      }
      case 257710925: {
        if(tag.equals("layout/activity_detail_0")) {
          return R.layout.activity_detail;
        }
        break;
      }
    }
    return 0;
  }

  @Override
  public String convertBrIdToString(int id) {
    String tmpVal = InnerBrLookup.sKeys.get(id);
    return tmpVal;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(31);

    static {
      sKeys.put(com.movie.maotrailer.BR._all, "_all");
      sKeys.put(com.movie.maotrailer.BR.retryListener, "retryListener");
      sKeys.put(com.movie.maotrailer.BR.videos, "videos");
      sKeys.put(com.movie.maotrailer.BR.profileImage, "profileImage");
      sKeys.put(com.movie.maotrailer.BR.crewJob, "crewJob");
      sKeys.put(com.movie.maotrailer.BR.title, "title");
      sKeys.put(com.movie.maotrailer.BR.result, "result");
      sKeys.put(com.movie.maotrailer.BR.totalResults, "totalResults");
      sKeys.put(com.movie.maotrailer.BR.credits, "credits");
      sKeys.put(com.movie.maotrailer.BR.genres, "genres");
      sKeys.put(com.movie.maotrailer.BR.crews, "crews");
      sKeys.put(com.movie.maotrailer.BR.id, "id");
      sKeys.put(com.movie.maotrailer.BR.firstAirData, "firstAirData");
      sKeys.put(com.movie.maotrailer.BR.results, "results");
      sKeys.put(com.movie.maotrailer.BR.videoResults, "videoResults");
      sKeys.put(com.movie.maotrailer.BR.key, "key");
      sKeys.put(com.movie.maotrailer.BR.posterPath, "posterPath");
      sKeys.put(com.movie.maotrailer.BR.overview, "overview");
      sKeys.put(com.movie.maotrailer.BR.voteAverage, "voteAverage");
      sKeys.put(com.movie.maotrailer.BR.releaseDate, "releaseDate");
      sKeys.put(com.movie.maotrailer.BR.popupClickListener, "popupClickListener");
      sKeys.put(com.movie.maotrailer.BR.itemClickListener, "itemClickListener");
      sKeys.put(com.movie.maotrailer.BR.casts, "casts");
      sKeys.put(com.movie.maotrailer.BR.name, "name");
      sKeys.put(com.movie.maotrailer.BR.totalPages, "totalPages");
      sKeys.put(com.movie.maotrailer.BR.profilePath, "profilePath");
      sKeys.put(com.movie.maotrailer.BR.page, "page");
      sKeys.put(com.movie.maotrailer.BR.backdropPath, "backdropPath");
      sKeys.put(com.movie.maotrailer.BR.job, "job");
      sKeys.put(com.movie.maotrailer.BR.favorite, "favorite");
      sKeys.put(com.movie.maotrailer.BR.castName, "castName");
    }
  }
}
