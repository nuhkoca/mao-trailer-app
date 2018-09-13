package com.movie.maotrailer.data.remote.item;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.movie.maotrailer.BR;

import java.util.List;

public class Response extends BaseObservable {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<Results> results;

    @Bindable
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        notifyPropertyChanged(BR.page);
    }

    @Bindable
    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
        notifyPropertyChanged(BR.totalResults);
    }

    @Bindable
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        notifyPropertyChanged(BR.totalPages);
    }

    @Bindable
    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
        notifyPropertyChanged(BR.results);
    }
}
