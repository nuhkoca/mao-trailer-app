package com.movie.maotrailer.ui.main.fragments.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.movie.maotrailer.R;
import com.movie.maotrailer.databinding.FragmentProfileBinding;
import com.movie.maotrailer.ui.favorite.FavoriteActivity;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends DaggerFragment implements View.OnClickListener {

    private FragmentProfileBinding mFragmentProfileBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        mFragmentProfileBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.fragment_profile,
                container,
                false);

        return mFragmentProfileBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mFragmentProfileBinding.btnFavorites.setOnClickListener(this);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_list_view).setVisible(false);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnFavorites) {
            startActivity(new Intent(getActivity(), FavoriteActivity.class));
        }
    }
}
