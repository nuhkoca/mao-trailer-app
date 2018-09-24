package com.movie.maotrailer.ui.detail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.widget.Toast;

import com.movie.maotrailer.R;
import com.movie.maotrailer.api.NetworkState;
import com.movie.maotrailer.api.repository.EndpointRepository;
import com.movie.maotrailer.data.local.entity.FavoriteThings;
import com.movie.maotrailer.data.local.repository.FavoriteThingsRepository;
import com.movie.maotrailer.data.remote.addendum.Cast;
import com.movie.maotrailer.data.remote.addendum.CastCrewResponse;
import com.movie.maotrailer.data.remote.addendum.Crew;
import com.movie.maotrailer.data.remote.item.Results;
import com.movie.maotrailer.databinding.ActivityDetailBinding;
import com.movie.maotrailer.helper.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class DetailViewModel extends AndroidViewModel {

    private EndpointRepository endpointRepository;
    private CompositeDisposable compositeDisposable;
    private FavoriteThingsRepository favoriteThingsRepository;
    private ActivityDetailBinding activityDetailBinding;

    private MutableLiveData<CastCrewResponse> mCastCrewResponse;
    private MutableLiveData<NetworkState> mInitialLoading;
    private String mType;
    private int mId;
    private Results results;

    @Inject
    DetailViewModel(Application application, EndpointRepository endpointRepository, CompositeDisposable compositeDisposable, FavoriteThingsRepository favoriteThingsRepository) {
        super(application);
        this.endpointRepository = endpointRepository;
        this.compositeDisposable = compositeDisposable;
        this.favoriteThingsRepository = favoriteThingsRepository;

        mCastCrewResponse = new MutableLiveData<>();
        mInitialLoading = new MutableLiveData<>();
    }

    public void setPreconditions(String type, int id) {
        this.mType = type;
        this.mId = id;
    }

    public void fetchCastCrew() {
        Disposable castCrew = endpointRepository.getCastCrewList(mType, mId)
                .filter(castCrewResponse -> {
                    filterCrew(castCrewResponse);
                    return true;
                })
                .doOnComplete(() -> Timber.d("Crew filtering completed"))
                .filter(castCrewResponse -> {
                    filterCast(castCrewResponse);
                    return true;
                })
                .doOnComplete(() -> Timber.d("Cast filtering completed"))
                .subscribe(this::onSuccess, this::onError);

        compositeDisposable.add(castCrew);
    }

    private void onError(Throwable throwable) {
        mInitialLoading.setValue(new NetworkState(NetworkState.Status.FAILED));
        Timber.d(throwable);
    }

    private void onSuccess(CastCrewResponse castCrewResponse) {
        if (castCrewResponse != null) {
            mInitialLoading.setValue(NetworkState.LOADED);
            mCastCrewResponse.setValue(castCrewResponse);
        } else {
            mInitialLoading.setValue(new NetworkState(NetworkState.Status.NO_ITEM));
        }
    }

    private void filterCrew(CastCrewResponse castCrewResponse) {
        if (castCrewResponse != null) {
            List<Crew> crewList = new ArrayList<>();

            if (castCrewResponse.getCredits().getCrews() != null
                    && castCrewResponse.getCredits().getCrews().size() > 0) {
                Crew crew;

                for (int i = 0; i < castCrewResponse.getCredits().getCrews().size(); i++) {
                    if (castCrewResponse.getCredits().getCrews().get(i).getJob().equals(Constants.DIRECTOR_PREFIX)) {
                        crew = new Crew();

                        crew.setJob(castCrewResponse.getCredits().getCrews().get(i).getJob());
                        crew.setName(castCrewResponse.getCredits().getCrews().get(i).getName());
                        crew.setProfilePath(castCrewResponse.getCredits().getCrews().get(i).getProfilePath());

                        crewList.add(i, crew);
                    }
                }
            } else {
                crewList.add(null);
            }

            castCrewResponse.getCredits().setCrews(crewList);
        }
    }

    private void filterCast(CastCrewResponse castCrewResponse) {
        if (castCrewResponse != null) {
            List<Cast> castList = new ArrayList<>();

            if (castCrewResponse.getCredits().getCasts() != null
                    && castCrewResponse.getCredits().getCasts().size() > 0) {
                Cast cast;

                for (int j = 0; j < castCrewResponse.getCredits().getCasts().size(); j++) {
                    cast = new Cast();
                    if (!TextUtils.isEmpty(castCrewResponse.getCredits().getCasts().get(j).getProfilePath())) {
                        cast.setProfilePath(castCrewResponse.getCredits().getCasts().get(j).getProfilePath());
                        cast.setName(castCrewResponse.getCredits().getCasts().get(j).getName());

                        castList.add(j, cast);
                    } else {
                        cast.setProfilePath("null");
                        cast.setName(castCrewResponse.getCredits().getCasts().get(j).getName());

                        castList.add(j, cast);
                    }
                }
            } else {
                castList.add(null);
            }

            castCrewResponse.getCredits().setCasts(castList);
        }
    }

    public void shuffleVideo(CastCrewResponse castCrewResponse) {
        Random rnd = new Random();
        if (castCrewResponse.getVideos().getVideoResults() != null
                && castCrewResponse.getVideos().getVideoResults().size() > 0) {
            int rndVideo = rnd.nextInt(castCrewResponse.getVideos().getVideoResults().size());
            String key = castCrewResponse.getVideos().getVideoResults().get(rndVideo).getKey();

            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW);
            youtubeIntent.setData(Uri.parse(Constants.YOUTUBE_APP_PREFIX + key));

            if (youtubeIntent.resolveActivity(getApplication().getPackageManager()) != null) {
                getApplication().startActivity(youtubeIntent);
            } else {
                Toast.makeText(getApplication().getApplicationContext(), getApplication().getString(R.string.no_youtube_app), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplication().getApplicationContext(), getApplication().getString(R.string.no_video_found), Toast.LENGTH_SHORT).show();
        }
    }

    public void setBinding(ActivityDetailBinding activityDetailBinding) {
        this.activityDetailBinding = activityDetailBinding;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public void addToDB() {
        FavoriteThings favoriteThings = new FavoriteThings(
                results.getId(),
                results.getPosterPath(),
                (!TextUtils.isEmpty(results.getReleaseDate()) ? results.getReleaseDate().substring(0, 4) : results.getFirstAirDate().substring(0, 4)),
                (!TextUtils.isEmpty(results.getName()) ? results.getName() : results.getTitle()),
                results.getVoteAverage()
        );

        favoriteThingsRepository.insertOrThrow(favoriteThings, results.getId(), result -> {
            if (result) {
                Snackbar snackbar = Snackbar.make(activityDetailBinding.clDetail,
                        String.format(getApplication().getString(R.string.constraint_exception_text),
                                (!TextUtils.isEmpty(results.getName()) ? results.getName() : results.getTitle())), Snackbar.LENGTH_SHORT);
                snackbar.setAction(getApplication().getString(R.string.dismiss_action_text), null);
                snackbar.show();
            } else {
                Snackbar snackbar = Snackbar.make(activityDetailBinding.clDetail,
                        String.format(getApplication().getString(R.string.database_adding_info_text),
                                (!TextUtils.isEmpty(results.getName()) ? results.getName() : results.getTitle())), Snackbar.LENGTH_SHORT);
                snackbar.setAction(getApplication().getString(R.string.dismiss_action_text), null);
                snackbar.show();
            }
        });
    }

    public MutableLiveData<CastCrewResponse> getCastCrewResponseMutableLiveData() {
        return mCastCrewResponse;
    }

    public MutableLiveData<NetworkState> getInitialLoading() {
        return mInitialLoading;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
