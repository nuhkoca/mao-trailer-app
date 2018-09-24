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
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYDETAIL = 1;

  private static final int LAYOUT_ACTIVITYFAVORITE = 2;

  private static final int LAYOUT_ACTIVITYMAIN = 3;

  private static final int LAYOUT_CASTCARD = 4;

  private static final int LAYOUT_DETAILPAGETOP = 5;

  private static final int LAYOUT_FAVORITEITEMCARD = 6;

  private static final int LAYOUT_FRAGMENTMUTUAL = 7;

  private static final int LAYOUT_FRAGMENTPROFILE = 8;

  private static final int LAYOUT_ITEMCARD = 9;

  private static final int LAYOUT_NETWORKSTATEITEM = 10;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(10);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.activity_detail, LAYOUT_ACTIVITYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.activity_favorite, LAYOUT_ACTIVITYFAVORITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.cast_card, LAYOUT_CASTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.detail_page_top, LAYOUT_DETAILPAGETOP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.favorite_item_card, LAYOUT_FAVORITEITEMCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.fragment_mutual, LAYOUT_FRAGMENTMUTUAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.item_card, LAYOUT_ITEMCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.movie.maotrailer.R.layout.network_state_item, LAYOUT_NETWORKSTATEITEM);
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
        case  LAYOUT_ACTIVITYDETAIL: {
          if ("layout/activity_detail_0".equals(tag)) {
            return new ActivityDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFAVORITE: {
          if ("layout/activity_favorite_0".equals(tag)) {
            return new ActivityFavoriteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_favorite is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
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
        case  LAYOUT_FAVORITEITEMCARD: {
          if ("layout/favorite_item_card_0".equals(tag)) {
            return new FavoriteItemCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for favorite_item_card is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMUTUAL: {
          if ("layout/fragment_mutual_0".equals(tag)) {
            return new FragmentMutualBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_mutual is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCARD: {
          if ("layout/item_card_0".equals(tag)) {
            return new ItemCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_card is invalid. Received: " + tag);
        }
        case  LAYOUT_NETWORKSTATEITEM: {
          if ("layout/network_state_item_0".equals(tag)) {
            return new NetworkStateItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for network_state_item is invalid. Received: " + tag);
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
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(32);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "retryListener");
      sKeys.put(2, "videos");
      sKeys.put(3, "profileImage");
      sKeys.put(4, "crewJob");
      sKeys.put(5, "title");
      sKeys.put(6, "result");
      sKeys.put(7, "firstAirDate");
      sKeys.put(8, "totalResults");
      sKeys.put(9, "credits");
      sKeys.put(10, "genres");
      sKeys.put(11, "crews");
      sKeys.put(12, "id");
      sKeys.put(13, "results");
      sKeys.put(14, "videoResults");
      sKeys.put(15, "key");
      sKeys.put(16, "posterPath");
      sKeys.put(17, "overview");
      sKeys.put(18, "voteAverage");
      sKeys.put(19, "releaseDate");
      sKeys.put(20, "popupClickListener");
      sKeys.put(21, "itemClickListener");
      sKeys.put(22, "casts");
      sKeys.put(23, "name");
      sKeys.put(24, "totalPages");
      sKeys.put(25, "profilePath");
      sKeys.put(26, "page");
      sKeys.put(27, "backdropPath");
      sKeys.put(28, "job");
      sKeys.put(29, "favorite");
      sKeys.put(30, "castName");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(10);

    static {
      sKeys.put("layout/activity_detail_0", com.movie.maotrailer.R.layout.activity_detail);
      sKeys.put("layout/activity_favorite_0", com.movie.maotrailer.R.layout.activity_favorite);
      sKeys.put("layout/activity_main_0", com.movie.maotrailer.R.layout.activity_main);
      sKeys.put("layout/cast_card_0", com.movie.maotrailer.R.layout.cast_card);
      sKeys.put("layout/detail_page_top_0", com.movie.maotrailer.R.layout.detail_page_top);
      sKeys.put("layout/favorite_item_card_0", com.movie.maotrailer.R.layout.favorite_item_card);
      sKeys.put("layout/fragment_mutual_0", com.movie.maotrailer.R.layout.fragment_mutual);
      sKeys.put("layout/fragment_profile_0", com.movie.maotrailer.R.layout.fragment_profile);
      sKeys.put("layout/item_card_0", com.movie.maotrailer.R.layout.item_card);
      sKeys.put("layout/network_state_item_0", com.movie.maotrailer.R.layout.network_state_item);
    }
  }
}
