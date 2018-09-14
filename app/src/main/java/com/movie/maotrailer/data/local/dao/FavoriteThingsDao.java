package com.movie.maotrailer.data.local.dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.movie.maotrailer.data.local.entity.FavoriteThings;

@Dao
public interface FavoriteThingsDao {
    @Query("SELECT * FROM favorite_things")
    DataSource.Factory<Integer, FavoriteThings> getAll();

    @Query("SELECT iid FROM favorite_things WHERE iid = :iid LIMIT 1")
    int getItemById(int iid);

    @Insert
    void insertItem(FavoriteThings favoriteThings);

    @Query("DELETE FROM favorite_things WHERE iid = :iid")
    void deleteItem(int iid);

    @Query("DELETE FROM favorite_things")
    void deleteAll();
}
