package com.movie.maotrailer.data.remote.item;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.util.DiffUtil;

import com.google.gson.annotations.SerializedName;
import com.movie.maotrailer.BR;

import java.util.List;

public class Results extends BaseObservable implements Parcelable {

    public static DiffUtil.ItemCallback<Results> DIFF_CALLBACK = new DiffUtil.ItemCallback<Results>() {
        @Override
        public boolean areItemsTheSame(Results oldItem, Results newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(Results oldItem, Results newItem) {
            return oldItem.equals(newItem);
        }
    };

    @SerializedName("id")
    private int id;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("name")
    private String name;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("genre_ids")
    private List<Integer> genres;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("first_air_date")
    private String firstAirData;

    @SuppressWarnings("unchecked")
    protected Results(Parcel in) {
        id = in.readInt();
        voteAverage = in.readFloat();
        title = in.readString();
        name = in.readString();
        posterPath = in.readString();
        genres = in.readArrayList(Results.class.getClassLoader());
        backdropPath = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        firstAirData = in.readString();
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
        notifyPropertyChanged(BR.voteAverage);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        notifyPropertyChanged(BR.posterPath);
    }

    @Bindable
    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
        notifyPropertyChanged(BR.genres);
    }

    @Bindable
    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        notifyPropertyChanged(BR.backdropPath);
    }

    @Bindable
    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
        notifyPropertyChanged(BR.overview);
    }

    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);
    }

    @Bindable
    public String getFirstAirData() {
        return firstAirData;
    }

    public void setFirstAirData(String firstAirData) {
        this.firstAirData = firstAirData;
        notifyPropertyChanged(BR.firstAirData);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() == obj.getClass()) {
            return true;
        }

        Results countryResult = (Results) obj;

        return countryResult.id == this.id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeFloat(voteAverage);
        dest.writeString(title);
        dest.writeString(name);
        dest.writeString(posterPath);
        dest.writeList(genres);
        dest.writeString(backdropPath);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeString(firstAirData);
    }
}
