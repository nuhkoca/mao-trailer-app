package com.movie.maotrailer.api.repository;

import android.support.annotation.NonNull;

import com.movie.maotrailer.BuildConfig;
import com.movie.maotrailer.api.ITMDBService;
import com.movie.maotrailer.data.remote.addendum.CastCrewResponse;
import com.movie.maotrailer.data.remote.item.Response;
import com.movie.maotrailer.helper.Constants;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class EndpointRepository {

    @NonNull
    private ITMDBService itmdbService;

    @Inject
    EndpointRepository(@NonNull ITMDBService itmdbService) {
        this.itmdbService = itmdbService;
    }

    public Single<Response> getList(String type, String category, long page) {
        return itmdbService.getList(type, category, BuildConfig.APIKey, page)
                .retry(Constants.RETRY_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<CastCrewResponse> getCastCrewList(String type, int id) {
        return itmdbService.getCastCrew(type, id, BuildConfig.APIKey, 1)
                .retry(Constants.RETRY_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
