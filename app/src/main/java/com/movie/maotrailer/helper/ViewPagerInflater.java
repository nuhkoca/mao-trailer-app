package com.movie.maotrailer.helper;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.movie.maotrailer.ui.main.fragments.movie.MovieFragment;
import com.movie.maotrailer.ui.main.fragments.profile.ProfileFragment;
import com.movie.maotrailer.ui.main.fragments.tv.TvFragment;

/**
 * A ViewPagerHelper that caches the fragments in the backstack and survives against screen orientation
 */

public class ViewPagerInflater extends FragmentPagerAdapter {
    private Fragment frags[] = new Fragment[Constants.VIEW_PAGER_OFFSET_LIMIT];

    public ViewPagerInflater(FragmentManager fm) {
        super(fm);
        frags[0] = new MovieFragment();
        frags[1] = new TvFragment();
        frags[2] = new ProfileFragment();
    }

    @Override
    public Fragment getItem(int position) {
        return frags[position];
    }

    @Override
    public int getCount() {
        return frags.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        frags[position] = (Fragment) super.instantiateItem(container, position);
        return frags[position];
    }
}
