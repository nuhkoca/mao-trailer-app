package com.movie.maotrailer.paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.movie.maotrailer.data.remote.item.Results;

import javax.inject.Inject;

public class ItemDataSourceFactory extends DataSource.Factory<Long, Results> {

    private MutableLiveData<ItemDataSource> itemDataSourceMutableLiveData;
    private ItemDataSource itemDataSource;

    @Inject
    public ItemDataSourceFactory(ItemDataSource itemDataSource) {
        this.itemDataSource = itemDataSource;

        itemDataSourceMutableLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource<Long, Results> create() {
        itemDataSourceMutableLiveData.postValue(itemDataSource);

        return itemDataSource;
    }

    public MutableLiveData<ItemDataSource> getItemDataSourceMutableLiveData() {
        return itemDataSourceMutableLiveData;
    }

    public ItemDataSource getItemDataSource() {
        return itemDataSource;
    }
}
