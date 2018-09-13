package com.movie.maotrailer.ui.detail;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movie.maotrailer.BR;
import com.movie.maotrailer.R;
import com.movie.maotrailer.data.remote.addendum.Cast;
import com.movie.maotrailer.data.remote.addendum.Credits;
import com.movie.maotrailer.data.remote.addendum.Crew;
import com.movie.maotrailer.databinding.CastCardBinding;

public class CastCrewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Credits mCredits;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        CastCardBinding castCardBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.cast_card, parent, false);

        return new CastCrewViewHolder(castCardBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (mCredits != null) {
            if (position == 0) {
                ((CastCrewViewHolder) holder).bindTo(mCredits.getCrews().get(position));
            } else {
                ((CastCrewViewHolder) holder).bindTo(mCredits.getCasts().get(position - 1));
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mCredits != null) {
            return mCredits.getCasts().size() + 1;
        } else {
            return 0;
        }
    }

    public void swapList(Credits credits) {
        this.mCredits = credits;
        notifyDataSetChanged();
    }

    class CastCrewViewHolder extends RecyclerView.ViewHolder {

        private CastCardBinding castCardBinding;

        CastCrewViewHolder(View itemView) {
            super(itemView);

            castCardBinding = DataBindingUtil.getBinding(itemView);
        }

        void bindTo(Cast cast) {
            castCardBinding.setVariable(BR.profileImage, cast.getProfilePath());
            castCardBinding.setVariable(BR.castName, cast.getName());
            castCardBinding.tvCrewJob.setVisibility(View.INVISIBLE);
            castCardBinding.executePendingBindings();
        }

        void bindTo(Crew crew) {
            castCardBinding.setVariable(BR.profileImage, crew.getProfilePath());
            castCardBinding.setVariable(BR.castName, crew.getName());
            castCardBinding.setVariable(BR.crewJob, crew.getJob());
            castCardBinding.tvCrewJob.setVisibility(View.VISIBLE);
            castCardBinding.executePendingBindings();
        }
    }
}
