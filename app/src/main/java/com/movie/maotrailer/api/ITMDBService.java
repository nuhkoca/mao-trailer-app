package com.movie.maotrailer.api;

import android.support.annotation.NonNull;

import com.movie.maotrailer.data.remote.addendum.CastCrewResponse;
import com.movie.maotrailer.data.remote.item.Response;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ITMDBService {

    enum Type {
        MOVIE("movie"),
        TV("tv");

        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getValue() {
            return type;
        }
    }

    enum Category {
        NOW_PLAYING("now_playing"),
        POPULAR("popular"),
        TOP_RATED("top_rated");

        private String category;

        Category(String category) {
            this.category = category;
        }

        public String getValue() {
            return category;
        }
    }

    @GET("{type}/{category}")
    Single<Response> getList(@Path("type") String type,
                             @Path("category") String category,
                             @Query("api_key") @NonNull String apiKey,
                             @Query("page") long page);

    @GET("{type}/{id}?append_to_response=credits,videos")
    Single<CastCrewResponse> getCastCrew(@Path("type") String type,
                                         @Path("id") int id,
                                         @Query("api_key") @NonNull String apiKey,
                                         @Query("page") int page);
}
