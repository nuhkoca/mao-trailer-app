package com.movie.maotrailer.ui.favorite;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.movie.maotrailer.R;
import com.movie.maotrailer.callback.IPopupMenuItemClickListener;
import com.movie.maotrailer.data.local.FavoriteThings;
import com.movie.maotrailer.databinding.FavoriteItemCardBinding;

public class FavoritesAdapter extends PagedListAdapter<FavoriteThings, RecyclerView.ViewHolder> {

    private IPopupMenuItemClickListener mIPopupMenuItemClickListener;

    FavoritesAdapter(IPopupMenuItemClickListener iPopupMenuItemClickListener) {
        super(FavoriteThings.DIFF_CALLBACK);

        this.mIPopupMenuItemClickListener = iPopupMenuItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        FavoriteItemCardBinding favoriteItemCardBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.favorite_item_card, parent, false);

        return new FavoriteViewHolder(favoriteItemCardBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FavoriteThings favoriteThings = getItem(position);

        if (favoriteThings != null) {
            ((FavoriteViewHolder) holder).bindTo(favoriteThings);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    class FavoriteViewHolder extends RecyclerView.ViewHolder {

        private FavoriteItemCardBinding favoriteItemCardBinding;

        FavoriteViewHolder(View itemView) {
            super(itemView);

            favoriteItemCardBinding = DataBindingUtil.getBinding(itemView);
        }

        void bindTo(FavoriteThings favoriteThings) {
            favoriteItemCardBinding.setVariable(BR.favorite, favoriteThings);
            favoriteItemCardBinding.setVariable(BR.popupClickListener, mIPopupMenuItemClickListener);

            favoriteItemCardBinding.executePendingBindings();
        }
    }
}