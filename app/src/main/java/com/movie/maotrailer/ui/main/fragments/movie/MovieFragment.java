package com.movie.maotrailer.ui.main.fragments.movie;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.movie.maotrailer.R;
import com.movie.maotrailer.api.ITMDBService;
import com.movie.maotrailer.api.NetworkState;
import com.movie.maotrailer.callback.IItemClickListener;
import com.movie.maotrailer.callback.IRetryListener;
import com.movie.maotrailer.data.remote.item.Results;
import com.movie.maotrailer.databinding.FragmentMutualBinding;
import com.movie.maotrailer.helper.AutoClearedValue;
import com.movie.maotrailer.helper.Constants;
import com.movie.maotrailer.ui.detail.DetailActivity;
import com.movie.maotrailer.ui.main.fragments.MutualAdapter;
import com.movie.maotrailer.utils.ColumnUtils;
import com.movie.maotrailer.utils.ConnectionUtils;
import com.movie.maotrailer.utils.SharedPreferencesUtil;

import java.util.Objects;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends DaggerFragment implements IRetryListener,
        IItemClickListener<Results>,
        View.OnClickListener {

    private AutoClearedValue<FragmentMutualBinding> mFragmentMutualBindingAutoClearedValue;
    private MovieViewModel mMovieViewModel;
    private MutualAdapter mMutualAdapter;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    ColumnUtils columnUtils;

    @Inject
    SharedPreferencesUtil sharedPreferencesUtil;

    @Inject
    ConnectionUtils connectionUtils;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMutualBinding fragmentMutualBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_mutual,
                container,
                false);

        mFragmentMutualBindingAutoClearedValue = new AutoClearedValue<>(this, fragmentMutualBinding);

        return fragmentMutualBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMovieViewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel.class);

        int spanCount = columnUtils.getOptimalNumberOfColumn(getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), spanCount);
        mFragmentMutualBindingAutoClearedValue.get().rvMutual.setLayoutManager(layoutManager);

        mMutualAdapter = new MutualAdapter(this, this);

        mMovieViewModel.setPreconditions(ITMDBService.Type.MOVIE, ITMDBService.Category.NOW_PLAYING.getValue());
        fetchResults();

        mFragmentMutualBindingAutoClearedValue.get().tvErrButtonMutual.setOnClickListener(this);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.top_rated_sub_item).setVisible(false);
        menu.findItem(R.id.now_playing_sub_item).setVisible(true);

        Objects.requireNonNull(getActivity()).invalidateOptionsMenu();

        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClicked = item.getItemId();

        if (itemThatWasClicked == R.id.now_playing_sub_item) {
            mMovieViewModel.setPreconditions(ITMDBService.Type.MOVIE, ITMDBService.Category.NOW_PLAYING.getValue());
            sharedPreferencesUtil.putStringData(getString(R.string.movie_category_key), ITMDBService.Category.NOW_PLAYING.getValue());
            refreshResults();
            return true;
        }
        if (itemThatWasClicked == R.id.popular_sub_item) {
            mMovieViewModel.setPreconditions(ITMDBService.Type.MOVIE, ITMDBService.Category.POPULAR.getValue());
            sharedPreferencesUtil.putStringData(getString(R.string.movie_category_key), ITMDBService.Category.POPULAR.getValue());
            refreshResults();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupIndicators() {
        mFragmentMutualBindingAutoClearedValue.get().pbMutual.setVisibility(View.VISIBLE);
        mMovieViewModel.getInitialLoading().observe(this, networkState -> {
            if (networkState != null) {
                if (networkState.getStatus() == NetworkState.Status.SUCCESS) {
                    mFragmentMutualBindingAutoClearedValue.get().pbMutual.setVisibility(View.GONE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrTextMutual.setVisibility(View.GONE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrButtonMutual.setVisibility(View.GONE);
                } else if (networkState.getStatus() == NetworkState.Status.FAILED) {
                    mFragmentMutualBindingAutoClearedValue.get().pbMutual.setVisibility(View.GONE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrTextMutual.setVisibility(View.VISIBLE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrButtonMutual.setVisibility(View.VISIBLE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrTextMutual.setText(getString(R.string.response_error_text));
                } else if (networkState.getStatus() == NetworkState.Status.NO_ITEM) {
                    mFragmentMutualBindingAutoClearedValue.get().pbMutual.setVisibility(View.GONE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrTextMutual.setVisibility(View.VISIBLE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrTextMutual.setText(getString(R.string.no_result_error_text));
                    mFragmentMutualBindingAutoClearedValue.get().tvErrButtonMutual.setVisibility(View.GONE);
                } else {
                    mFragmentMutualBindingAutoClearedValue.get().pbMutual.setVisibility(View.VISIBLE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrTextMutual.setVisibility(View.GONE);
                    mFragmentMutualBindingAutoClearedValue.get().tvErrButtonMutual.setVisibility(View.GONE);
                }
            }
        });

        mMovieViewModel.getNetworkState().observe(this, networkState -> {
            if (networkState != null) {
                mMutualAdapter.setNetworkState(networkState);
            }
        });
    }

    public void fetchResults() {
        mMovieViewModel.setNetworkState();
        setupIndicators();
        mMovieViewModel.getResult().observe(this, results -> {
            if (results != null) {
                mMutualAdapter.submitList(null);
                mMutualAdapter.submitList(results);
            }
        });

        mFragmentMutualBindingAutoClearedValue.get().rvMutual.setAdapter(mMutualAdapter);
    }

    public void refreshResults() {
        mMovieViewModel.setNetworkState();
        setupIndicators();
        mMovieViewModel.setPreconditions(ITMDBService.Type.MOVIE,
                sharedPreferencesUtil.getStringData(getString(R.string.movie_category_key),
                        ITMDBService.Category.NOW_PLAYING.getValue()));
        mMovieViewModel.refreshResult().observe(this, results -> {
            if (results != null) {
                mMutualAdapter.submitList(null);
                mMutualAdapter.submitList(results);
            }
        });
        mFragmentMutualBindingAutoClearedValue.get().rvMutual.setAdapter(mMutualAdapter);
    }

    @Override
    public void onRefresh() {
        if (connectionUtils.sniff()) {
            refreshResults();
        } else {
            Toast.makeText(getContext(), getString(R.string.no_active_connection), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(Results results, ImageView imageView) {
        Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
        detailIntent.putExtra(Constants.PARCELABLE_RESULTS, results);
        detailIntent.putExtra(Constants.TYPE_EXTRA, ITMDBService.Type.MOVIE.getValue());
        detailIntent.putExtra(Constants.SHARED_ELEMENT_TRANSITION_INTENT_KEY, ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat option = ActivityOptionsCompat
                .makeSceneTransitionAnimation(Objects.requireNonNull(getActivity()),
                        imageView,
                        ViewCompat.getTransitionName(imageView));

        startActivity(detailIntent, option.toBundle());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvErrButtonMutual) {
            refreshResults();
        }
    }

    @Override
    public void onDetach() {
        if (mMovieViewModel != null) {
            mMovieViewModel.onCleared();
        }
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        if (mMovieViewModel != null) {
            mMovieViewModel.onCleared();
        }

        super.onDestroy();
    }
}
