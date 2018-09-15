package com.movie.maotrailer.ui.main.fragments.movie;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.movie.maotrailer.api.ITMDBService;
import com.movie.maotrailer.api.NetworkState;
import com.movie.maotrailer.data.remote.item.Results;
import com.movie.maotrailer.helper.AppsExecutor;
import com.movie.maotrailer.helper.Constants;
import com.movie.maotrailer.paging.ItemDataSource;
import com.movie.maotrailer.paging.ItemDataSourceFactory;

import javax.inject.Inject;

public class MovieViewModel extends ViewModel {

    private LiveData<NetworkState> networkState;
    private LiveData<NetworkState> initialLoading;
    private LiveData<PagedList<Results>> result;

    private ItemDataSourceFactory itemDataSourceFactory;
    private AppsExecutor appsExecutor;

    @Inject
    MovieViewModel(ItemDataSourceFactory itemDataSourceFactory, AppsExecutor appsExecutor) {
        this.itemDataSourceFactory = itemDataSourceFactory;
        this.appsExecutor = appsExecutor;

        networkState = Transformations.switchMap(itemDataSourceFactory.getItemDataSourceMutableLiveData(),
                ItemDataSource::getNetworkState);
        initialLoading = Transformations.switchMap(itemDataSourceFactory.getItemDataSourceMutableLiveData(), ItemDataSource::getInitialState);

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(Constants.INITIAL_LOAD_SIZE_HINT)
                .setPrefetchDistance(Constants.PREFETCH_DISTANCE)
                .setPageSize(Constants.PAGE_SIZE)
                .build();

        result = new LivePagedListBuilder<>(itemDataSourceFactory, config)
                .setFetchExecutor(appsExecutor.networkIO())
                .build();
    }

    public void setPreconditions(ITMDBService.Type type, String category) {
        itemDataSourceFactory.getItemDataSource().setType(type);
        itemDataSourceFactory.getItemDataSource().setCategory(category);
    }

    public void setNetworkState(){
        networkState = Transformations.switchMap(itemDataSourceFactory.getItemDataSourceMutableLiveData(),
                ItemDataSource::getNetworkState);
        initialLoading = Transformations.switchMap(itemDataSourceFactory.getItemDataSourceMutableLiveData(), ItemDataSource::getInitialState);
    }

    public LiveData<PagedList<Results>> refreshResult() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(Constants.INITIAL_LOAD_SIZE_HINT)
                .setPrefetchDistance(Constants.PREFETCH_DISTANCE)
                .setPageSize(Constants.PAGE_SIZE)
                .build();

        result = new LivePagedListBuilder<>(itemDataSourceFactory, config)
                .setFetchExecutor(appsExecutor.networkIO())
                .build();

        return result;
    }

    public LiveData<NetworkState> getInitialLoading() {
        return initialLoading;
    }

    public LiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public LiveData<PagedList<Results>> getResult() {
        return result;
    }

    @Override
    protected void onCleared() {
        itemDataSourceFactory.getItemDataSource().clear();

        super.onCleared();
    }
}
