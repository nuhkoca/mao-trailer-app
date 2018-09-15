package com.movie.maotrailer.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.movie.maotrailer.R;
import com.movie.maotrailer.databinding.ActivityMainBinding;
import com.movie.maotrailer.helper.Constants;
import com.movie.maotrailer.helper.ViewPagerInflater;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding mActivityMainBinding;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    private MenuItem mPrevMenuItem;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        mActivityMainBinding.vpMain.setOffscreenPageLimit(Constants.VIEW_PAGER_OFFSET_LIMIT);
        mActivityMainBinding.vpMain.setAdapter(new ViewPagerInflater(getSupportFragmentManager()));

        mActivityMainBinding.bnvMain.setOnNavigationItemSelectedListener(this);
        mActivityMainBinding.bnvMain.setItemIconTintList(null);
        mActivityMainBinding.bnvMain.getMenu().getItem(0).setIcon(R.drawable.ic_icon_movies_selected);

        mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mPrevMenuItem != null) {
                    mPrevMenuItem.setChecked(false);
                } else {
                    mActivityMainBinding.bnvMain.getMenu().getItem(0).setChecked(false);
                }
                mActivityMainBinding.bnvMain.getMenu().getItem(position).setChecked(true);
                mPrevMenuItem = mActivityMainBinding.bnvMain.getMenu().getItem(position);

                if (position == 0) {
                    mActivityMainBinding.bnvMain.getMenu().getItem(position).setIcon(R.drawable.ic_icon_movies_selected);
                    mActivityMainBinding.bnvMain.getMenu().getItem(1).setIcon(R.drawable.ic_icon_tv);
                    mActivityMainBinding.bnvMain.getMenu().getItem(2).setIcon(R.drawable.ic_icon_profile);
                }
                if (position == 1) {
                    mActivityMainBinding.bnvMain.getMenu().getItem(0).setIcon(R.drawable.ic_icon_movies);
                    mActivityMainBinding.bnvMain.getMenu().getItem(position).setIcon(R.drawable.ic_icon_tv_selected);
                    mActivityMainBinding.bnvMain.getMenu().getItem(2).setIcon(R.drawable.ic_icon_profile);
                }
                if (position == 2) {
                    mActivityMainBinding.bnvMain.getMenu().getItem(0).setIcon(R.drawable.ic_icon_movies);
                    mActivityMainBinding.bnvMain.getMenu().getItem(1).setIcon(R.drawable.ic_icon_tv);
                    mActivityMainBinding.bnvMain.getMenu().getItem(position).setIcon(R.drawable.ic_icon_profile_selected);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        mActivityMainBinding.vpMain.addOnPageChangeListener(mOnPageChangeListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemThatWasClicked;

        if (item.getItemId() < 0) {
            itemThatWasClicked = 0;
        } else {
            itemThatWasClicked = item.getItemId();
        }

        switch (itemThatWasClicked) {
            case R.id.bottom_nav_movie:
                item.setIcon(R.drawable.ic_icon_movies_selected);
                mActivityMainBinding.bnvMain.getMenu().getItem(1).setIcon(R.drawable.ic_icon_tv);
                mActivityMainBinding.bnvMain.getMenu().getItem(2).setIcon(R.drawable.ic_icon_profile);
                mActivityMainBinding.vpMain.setCurrentItem(0);
                return true;

            case R.id.bottom_nav_tv:
                item.setIcon(R.drawable.ic_icon_tv_selected);
                mActivityMainBinding.bnvMain.getMenu().getItem(0).setIcon(R.drawable.ic_icon_movies);
                mActivityMainBinding.bnvMain.getMenu().getItem(2).setIcon(R.drawable.ic_icon_profile);
                mActivityMainBinding.vpMain.setCurrentItem(1);
                return true;

            case R.id.bottom_nav_profile:
                item.setIcon(R.drawable.ic_icon_profile_selected);
                mActivityMainBinding.bnvMain.getMenu().getItem(0).setIcon(R.drawable.ic_icon_movies);
                mActivityMainBinding.bnvMain.getMenu().getItem(1).setIcon(R.drawable.ic_icon_tv);
                mActivityMainBinding.vpMain.setCurrentItem(2);
                return true;

            default:
                break;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        int timeDelay = getResources().getInteger(R.integer.delay_in_seconds_to_close);

        if (mBackPressed + timeDelay > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), getString(R.string.twice_press_to_exit),
                    Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener = null;
        }

        super.onDestroy();
    }
}
