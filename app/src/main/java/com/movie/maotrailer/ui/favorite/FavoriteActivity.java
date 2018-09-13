package com.movie.maotrailer.ui.favorite;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.movie.maotrailer.R;
import com.movie.maotrailer.callback.IPopupMenuItemClickListener;
import com.movie.maotrailer.data.local.FavoriteThings;
import com.movie.maotrailer.databinding.ActivityFavoriteBinding;
import com.movie.maotrailer.utils.ColumnUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class FavoriteActivity extends DaggerAppCompatActivity implements IPopupMenuItemClickListener<FavoriteThings> {

    private ActivityFavoriteBinding mActivityFavoriteBinding;
    private FavoriteViewModel mFavoriteViewModel;
    private FavoritesAdapter mFavoritesAdapter;

    private PagedList<FavoriteThings> mFavoriteThingsList;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    ColumnUtils columnUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityFavoriteBinding = DataBindingUtil.setContentView(this, R.layout.activity_favorite);

        mFavoriteViewModel = ViewModelProviders.of(this, viewModelFactory).get(FavoriteViewModel.class);

        setupUI();
    }

    private void setupUI() {
        int spanCount = columnUtils.getOptimalNumberOfColumn(this);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);

        mActivityFavoriteBinding.rvFavorite.setLayoutManager(gridLayoutManager);

        mFavoritesAdapter = new FavoritesAdapter(this);

        mFavoriteViewModel.getResult().observe(this, favoriteThings -> {
            if (favoriteThings != null && favoriteThings.size() > 0) {
                mFavoritesAdapter.submitList(null);
                mFavoritesAdapter.submitList(favoriteThings);
                mActivityFavoriteBinding.pbFavorite.setVisibility(View.GONE);
                mActivityFavoriteBinding.tvErrTextFavorite.setVisibility(View.GONE);

                mFavoriteThingsList = favoriteThings;
            } else {
                mActivityFavoriteBinding.pbFavorite.setVisibility(View.GONE);
                mActivityFavoriteBinding.tvErrTextFavorite.setText(getString(R.string.no_item_in_db_warning_text));
                mActivityFavoriteBinding.tvErrTextFavorite.setVisibility(View.VISIBLE);
            }
        });

        mActivityFavoriteBinding.rvFavorite.setAdapter(mFavoritesAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClicked = item.getItemId();

        switch (itemThatWasClicked) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.delete_all:
                deleteAll();
                return true;

            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPopupMenuItemClick(FavoriteThings list, View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);

        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.overflow_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            int itemThatWasClicked = item.getItemId();

            switch (itemThatWasClicked) {
                case R.id.remove_from_fav:
                    deleteItem(list);
                    return true;

                default:
                    return false;
            }
        });

        popupMenu.show();

    }

    private void deleteItem(FavoriteThings favoriteThings) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(String.format(getString(R.string.item_removing_warning_title), favoriteThings.getName()))
                .setMessage(getString(R.string.item_removing_warning_text))
                .setPositiveButton(getString(R.string.ok_action_text), (dialog1, which) -> {

                    mFavoriteViewModel.deleteItem(favoriteThings);
                    getAll();
                    dialog1.dismiss();

                    Snackbar snackbar = Snackbar.make(mActivityFavoriteBinding.clFavorite,
                            String.format(getString(R.string.item_deleted_info_text), favoriteThings.getName()), Snackbar.LENGTH_SHORT);

                    snackbar.setAction(getString(R.string.dismiss_action_text), null);

                    snackbar.show();

                })
                .setNegativeButton(getString(R.string.cancel_action_text), (dialog12, which) -> {
                    dialog12.dismiss();
                })
                .setCancelable(false)
                .create();

        dialog.show();
    }

    private void deleteAll() {
        if (mFavoriteThingsList != null && mFavoriteThingsList.size() > 0) {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.all_item_removing_warning_title))
                    .setMessage(getString(R.string.item_removing_warning_text))
                    .setPositiveButton(getString(R.string.ok_action_text), (dialog1, which) -> {

                        mFavoriteViewModel.deleteAll();
                        getAll();
                        dialog1.dismiss();

                        Snackbar snackbar = Snackbar.make(mActivityFavoriteBinding.clFavorite,
                                getString(R.string.all_item_deleted_info_text), Snackbar.LENGTH_SHORT);

                        snackbar.setAction(getString(R.string.dismiss_action_text), null);

                        snackbar.show();

                    })
                    .setNegativeButton(getString(R.string.cancel_action_text), (dialog12, which) -> {
                        dialog12.dismiss();
                    })
                    .setCancelable(false)
                    .create();

            dialog.show();
        }
    }

    private void getAll() {
        mFavoriteViewModel.refreshResult().observe(this, favoriteThings -> {
            if (favoriteThings != null) {
                mFavoritesAdapter.submitList(null);
                mFavoritesAdapter.submitList(favoriteThings);
                this.mFavoriteThingsList = favoriteThings;
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mFavoriteViewModel != null) {
            mFavoriteViewModel.onCleared();
        }

        super.onDestroy();
    }
}
