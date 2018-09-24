package com.movie.maotrailer.ui.detail;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.movie.maotrailer.R;
import com.movie.maotrailer.api.NetworkState;
import com.movie.maotrailer.data.local.repository.FavoriteThingsRepository;
import com.movie.maotrailer.data.remote.addendum.CastCrewResponse;
import com.movie.maotrailer.data.remote.item.Results;
import com.movie.maotrailer.databinding.ActivityDetailBinding;
import com.movie.maotrailer.helper.Constants;
import com.movie.maotrailer.utils.AppUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class DetailActivity extends DaggerAppCompatActivity {

    private ActivityDetailBinding mActivityDetailBinding;
    private Results results;
    private DetailViewModel mDetailViewModel;
    private CastCrewAdapter mCastCrewAdapter;
    private String mExtraTextType;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    FavoriteThingsRepository favoriteThingsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtils.hideStatusBar(this);
        mActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        supportStartPostponedEnterTransition();

        setSupportActionBar(mActivityDetailBinding.toolbarDetail);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        mDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);

        results = getIntent().getParcelableExtra(Constants.PARCELABLE_RESULTS);

        setupUI();
    }

    private void setupUI() {
        mActivityDetailBinding.setVariable(BR.result, results);
        mActivityDetailBinding.lDetailPageTop.setVariable(BR.result, results);
        mActivityDetailBinding.lDetailPageTop.rbAverage.setRating(results.getVoteAverage() / 2);
        mActivityDetailBinding.executePendingBindings();

        mActivityDetailBinding.lDetailPageTop.ivPoster.setTransitionName(getIntent().getStringExtra(Constants.SHARED_ELEMENT_TRANSITION_INTENT_KEY));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mActivityDetailBinding.rvCast.setLayoutManager(linearLayoutManager);
        mActivityDetailBinding.rvCast.setNestedScrollingEnabled(true);

        mCastCrewAdapter = new CastCrewAdapter();

        mExtraTextType = getIntent().getStringExtra(Constants.TYPE_EXTRA);

        mDetailViewModel.setPreconditions(mExtraTextType, results.getId());
        mDetailViewModel.fetchCastCrew();
        mDetailViewModel.getCastCrewResponseMutableLiveData().observe(this, castCrewResponse -> {
            if (castCrewResponse != null) {
                showCastCrew(castCrewResponse);
                shuffleVideo(castCrewResponse);
            }
        });

        mDetailViewModel.getInitialLoading().observe(this, networkState -> {
            if (networkState != null) {
                if (networkState.getStatus() == NetworkState.Status.SUCCESS) {
                    mActivityDetailBinding.pbCastCrew.setVisibility(View.GONE);
                } else {
                    mActivityDetailBinding.cvCastCrew.setVisibility(View.GONE);
                    mActivityDetailBinding.pbCastCrew.setVisibility(View.GONE);
                    mActivityDetailBinding.tvCastCrewHeader.setText(getString(R.string.no_cast_crew_title));
                }
            }
        });

        mDetailViewModel.setBinding(mActivityDetailBinding);
        mDetailViewModel.setResults(results);
    }

    private void showCastCrew(CastCrewResponse castCrewResponse) {
        mCastCrewAdapter.swapList(castCrewResponse.getCredits());
        mActivityDetailBinding.rvCast.setAdapter(mCastCrewAdapter);
    }

    private void shuffleVideo(CastCrewResponse castCrewResponse) {
        mActivityDetailBinding.ibPlay.setOnClickListener(v -> mDetailViewModel.shuffleVideo(castCrewResponse));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClicked = item.getItemId();

        switch (itemThatWasClicked) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                supportFinishAfterTransition();
                return true;

            case R.id.share:
                String text = String.format(
                        getString(R.string.share_extra_text), mExtraTextType,
                        (TextUtils.isEmpty(results.getTitle()) ? results.getName() : results.getTitle()));

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_extra_title)));
                return true;

            case R.id.fav:
                addToDB();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addToDB() {
        mDetailViewModel.addToDB();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    protected void onDestroy() {
        if (mDetailViewModel != null) {
            mDetailViewModel = null;
        }

        super.onDestroy();
    }
}
