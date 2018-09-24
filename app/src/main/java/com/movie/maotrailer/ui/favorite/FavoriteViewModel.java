package com.movie.maotrailer.ui.favorite;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.movie.maotrailer.data.local.entity.FavoriteThings;
import com.movie.maotrailer.data.local.repository.FavoriteThingsRepository;
import com.movie.maotrailer.helper.Constants;

import javax.inject.Inject;

public class FavoriteViewModel extends ViewModel {

    private LiveData<PagedList<FavoriteThings>> mFavoriteThingsList;
    private FavoriteThingsRepository favoriteThingsRepository;
    private LiveData<Integer> mDataCount;

    @Inject
    FavoriteViewModel(FavoriteThingsRepository favoriteThingsRepository) {
        this.favoriteThingsRepository = favoriteThingsRepository;

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPrefetchDistance(Constants.PAGE_SIZE)
                .setPageSize(Constants.PAGE_SIZE).build();

        mFavoriteThingsList = new LivePagedListBuilder<>(favoriteThingsRepository.getAll(), config).build();
        mDataCount = favoriteThingsRepository.getCount();
    }

    public LiveData<PagedList<FavoriteThings>> getResult() {
        return mFavoriteThingsList;
    }

    public LiveData<PagedList<FavoriteThings>> refreshResult() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPrefetchDistance(Constants.PAGE_SIZE)
                .setPageSize(Constants.PAGE_SIZE).build();

        mFavoriteThingsList = new LivePagedListBuilder<>(favoriteThingsRepository.getAll(), config).build();
        mDataCount = favoriteThingsRepository.getCount();

        return mFavoriteThingsList;
    }

    public LiveData<Integer> getDataCount() {
        return mDataCount;
    }

    public void deleteItem(FavoriteThings favoriteThings) {
        favoriteThingsRepository.deleteItem(favoriteThings.getIid());
    }

    public void deleteAll() {
        favoriteThingsRepository.deleteAll();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
