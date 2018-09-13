package com.movie.maotrailer.data.remote.addendum;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.movie.maotrailer.BR;

import java.util.List;

public class Videos extends BaseObservable {

    @SerializedName("results")
    private List<VideoResult> videoResults;

    @Bindable
    public List<VideoResult> getVideoResults() {
        return videoResults;
    }

    public void setVideoResults(List<VideoResult> videoResults) {
        this.videoResults = videoResults;
        notifyPropertyChanged(BR.videoResults);
    }
}
