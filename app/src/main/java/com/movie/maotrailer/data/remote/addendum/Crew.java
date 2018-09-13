package com.movie.maotrailer.data.remote.addendum;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.movie.maotrailer.BR;

public class Crew extends BaseObservable {

    @SerializedName("name")
    private String name;
    @SerializedName("job")
    private String job;
    @SerializedName("profile_path")
    private String profilePath;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
        notifyPropertyChanged(BR.job);
    }

    @Bindable
    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
        notifyPropertyChanged(BR.profilePath);
    }
}
