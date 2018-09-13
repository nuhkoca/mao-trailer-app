package com.movie.maotrailer.data.remote.addendum;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.movie.maotrailer.BR;

import java.util.List;

public class Credits extends BaseObservable {

    @SerializedName("cast")
    private List<Cast> casts;
    @SerializedName("crew")
    private List<Crew> crews;

    @Bindable
    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
        notifyPropertyChanged(BR.casts);
    }

    @Bindable
    public List<Crew> getCrews() {
        return crews;
    }

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
        notifyPropertyChanged(BR.crews);
    }
}
