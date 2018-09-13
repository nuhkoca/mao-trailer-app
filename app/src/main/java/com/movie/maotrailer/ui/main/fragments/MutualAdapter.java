package com.movie.maotrailer.ui.main.fragments;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movie.maotrailer.BR;
import com.movie.maotrailer.R;
import com.movie.maotrailer.api.NetworkState;
import com.movie.maotrailer.callback.IItemClickListener;
import com.movie.maotrailer.callback.IRetryListener;
import com.movie.maotrailer.data.remote.item.Results;
import com.movie.maotrailer.databinding.ItemCardBinding;
import com.movie.maotrailer.databinding.NetworkStateItemBinding;
import com.movie.maotrailer.helper.Constants;

public class MutualAdapter extends PagedListAdapter<Results, RecyclerView.ViewHolder> {

    private NetworkState mNetworkState;
    private IRetryListener mIRetryListener;
    private IItemClickListener mIItemClickListener;

    public MutualAdapter(IRetryListener iRetryListener, IItemClickListener iItemClickListener) {
        super(Results.DIFF_CALLBACK);

        this.mIRetryListener = iRetryListener;
        this.mIItemClickListener = iItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        if (viewType == R.layout.item_card) {
            ItemCardBinding itemCardBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.item_card, parent, false);

            return new MutualViewHolder(itemCardBinding.getRoot());
        } else {
            NetworkStateItemBinding networkStateItemBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.network_state_item, parent, false);

            return new NetworkViewHolder(networkStateItemBinding.getRoot());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case R.layout.item_card:
                if (getItem(position) != null) {
                    ((MutualViewHolder) holder).bindTo(getItem(position));
                }
                break;

            case R.layout.network_state_item:
                ((NetworkViewHolder) holder).bindTo(mNetworkState);
                break;

            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    private boolean hasExtraRow() {
        return mNetworkState != null && mNetworkState != NetworkState.LOADED;
    }

    @Override
    public int getItemViewType(int position) {
        if (hasExtraRow() && position == getItemCount() - 1) {
            return R.layout.network_state_item;
        } else {
            return R.layout.item_card;
        }
    }

    public void setNetworkState(NetworkState newNetworkState) {
        NetworkState previousState = this.mNetworkState;
        boolean previousExtraRow = hasExtraRow();
        this.mNetworkState = newNetworkState;
        boolean newExtraRow = hasExtraRow();
        if (previousExtraRow != newExtraRow) {
            if (previousExtraRow) {
                notifyItemRemoved(getItemCount());
            } else {
                notifyItemInserted(getItemCount());
            }
        } else if (newExtraRow && previousState != newNetworkState) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    class MutualViewHolder extends RecyclerView.ViewHolder {

        private ItemCardBinding itemCardBinding;

        MutualViewHolder(View itemView) {
            super(itemView);

            itemCardBinding = DataBindingUtil.getBinding(itemView);
        }

        void bindTo(Results results) {
            itemCardBinding.setVariable(BR.result, results);
            itemCardBinding.setVariable(BR.itemClickListener, mIItemClickListener);

            ViewCompat.setTransitionName(itemCardBinding.ivPoster,
                    (Constants.SHARED_ELEMENT_TRANSITION_KEY + String.valueOf(getAdapterPosition())));

            itemCardBinding.executePendingBindings();
        }
    }

    class NetworkViewHolder extends RecyclerView.ViewHolder {

        private NetworkStateItemBinding networkStateItemBinding;

        NetworkViewHolder(View itemView) {
            super(itemView);

            networkStateItemBinding = DataBindingUtil.getBinding(itemView);
        }

        void bindTo(NetworkState networkState) {
            networkStateItemBinding.setVariable(BR.retryListener, mIRetryListener);

            if (networkState != null && networkState.getStatus() == NetworkState.Status.RUNNING) {
                networkStateItemBinding.clNetwork.setVisibility(View.VISIBLE);
                networkStateItemBinding.pbNetwork.setVisibility(View.VISIBLE);
                networkStateItemBinding.tvNetworkErrButton.setVisibility(View.GONE);
                networkStateItemBinding.tvNetworkErr.setVisibility(View.GONE);
            } else if (networkState != null && networkState.getStatus() == NetworkState.Status.FAILED) {
                networkStateItemBinding.clNetwork.setVisibility(View.VISIBLE);
                networkStateItemBinding.pbNetwork.setVisibility(View.GONE);
                networkStateItemBinding.tvNetworkErrButton.setVisibility(View.VISIBLE);
                networkStateItemBinding.tvNetworkErr.setVisibility(View.VISIBLE);
            } else {
                networkStateItemBinding.clNetwork.setVisibility(View.GONE);
                networkStateItemBinding.pbNetwork.setVisibility(View.GONE);
                networkStateItemBinding.tvNetworkErrButton.setVisibility(View.GONE);
                networkStateItemBinding.tvNetworkErr.setVisibility(View.GONE);
            }

            networkStateItemBinding.executePendingBindings();
        }
    }
}
