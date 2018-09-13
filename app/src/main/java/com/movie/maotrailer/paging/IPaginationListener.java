package com.movie.maotrailer.paging;

import android.arch.paging.PageKeyedDataSource;

import java.util.List;

public interface IPaginationListener<Response, Result> {

    void onInitialError(Throwable throwable);

    void onInitialSuccess(Response response, PageKeyedDataSource.LoadInitialCallback<Long, Result> callback, List<Result> results);

    void onPaginationError(Throwable throwable);

    void onPaginationSuccess(Response response, PageKeyedDataSource.LoadCallback<Long, Result> callback, PageKeyedDataSource.LoadParams<Long> params, List<Result> results);

    void clear();
}
