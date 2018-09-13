package com.movie.maotrailer.paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.movie.maotrailer.api.ITMDBService;
import com.movie.maotrailer.api.NetworkState;
import com.movie.maotrailer.api.repository.EndpointRepository;
import com.movie.maotrailer.data.remote.item.Response;
import com.movie.maotrailer.data.remote.item.Results;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class ItemDataSource extends PageKeyedDataSource<Long, Results> implements IPaginationListener<Response, Results> {

    private EndpointRepository endpointRepository;
    private CompositeDisposable compositeDisposable;

    private MutableLiveData<NetworkState> mNetworkState;
    private MutableLiveData<NetworkState> mInitialState;

    private String mType;
    private String mCategory;

    @Inject
    public ItemDataSource(EndpointRepository endpointRepository, CompositeDisposable compositeDisposable) {
        this.endpointRepository = endpointRepository;
        this.compositeDisposable = compositeDisposable;

        mNetworkState = new MutableLiveData<>();
        mInitialState = new MutableLiveData<>();
    }

    public MutableLiveData<NetworkState> getNetworkState() {
        return mNetworkState;
    }

    public MutableLiveData<NetworkState> getInitialState() {
        return mInitialState;
    }

    public void setType(ITMDBService.Type type){
        mType = type.getValue();
    }

    private String getType() {
        return mType;
    }

    public void setCategory(String category){
        mCategory = category;
    }

    private String getCategory() {
        return mCategory;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, Results> callback) {
        List<Results> resultsList = new ArrayList<>();

        Disposable result = endpointRepository.getList(getType(), getCategory(), 1)
                .subscribe(response -> onInitialSuccess(response, callback, resultsList), this::onInitialError);

        compositeDisposable.add(result);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Results> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Results> callback) {
        List<Results> resultsList = new ArrayList<>();

        Disposable result = endpointRepository.getList(getType(), getCategory(), params.key)
                .subscribe(response -> onPaginationSuccess(response, callback, params, resultsList), this::onPaginationError);

        compositeDisposable.add(result);
    }

    @Override
    public void onInitialError(Throwable throwable) {
        mInitialState.postValue(new NetworkState(NetworkState.Status.FAILED));
        mNetworkState.postValue(new NetworkState(NetworkState.Status.FAILED));
        Timber.e(throwable);
    }

    @Override
    public void onInitialSuccess(Response response, PageKeyedDataSource.LoadInitialCallback<Long, Results> callback, List<Results> results) {
        if (response.getResults() != null && response.getResults().size() > 0) {
            results.addAll(response.getResults());
            callback.onResult(results, null, 2L);

            mInitialState.postValue(NetworkState.LOADED);
            mNetworkState.postValue(NetworkState.LOADED);
        } else {
            mInitialState.postValue(new NetworkState(NetworkState.Status.NO_ITEM));
            mNetworkState.postValue(new NetworkState(NetworkState.Status.NO_ITEM));
        }
    }

    @Override
    public void onPaginationError(Throwable throwable) {
        mNetworkState.postValue(new NetworkState(NetworkState.Status.FAILED));
        Timber.e(throwable);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onPaginationSuccess(Response response, LoadCallback<Long, Results> callback, LoadParams<Long> params, List<Results> results) {
        if (response.getResults() != null && response.getResults().size() > 0) {
            results.addAll(response.getResults());

            long nextKey = (params.key == response.getPage() - 1) ? null : params.key + 1;

            callback.onResult(results, nextKey);

            mNetworkState.postValue(NetworkState.LOADED);
        } else {
            mNetworkState.postValue(new NetworkState(NetworkState.Status.NO_ITEM));
        }
    }

    @Override
    public void clear() {
        compositeDisposable.clear();
    }
}
