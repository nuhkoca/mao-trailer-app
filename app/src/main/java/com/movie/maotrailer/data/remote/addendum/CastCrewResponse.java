package com.movie.maotrailer.data.remote.addendum;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.movie.maotrailer.BR;

public class CastCrewResponse extends BaseObservable {

    @SerializedName("id")
    private int id;
    @SerializedName("credits")
    private Credits credits;
    @SerializedName("videos")
    private Videos videos;

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
        notifyPropertyChanged(BR.credits);
    }

    @Bindable
    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
        notifyPropertyChanged(BR.videos);
    }
}
