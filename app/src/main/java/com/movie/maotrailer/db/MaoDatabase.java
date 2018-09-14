package com.movie.maotrailer.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.movie.maotrailer.data.local.entity.FavoriteThings;
import com.movie.maotrailer.data.local.dao.FavoriteThingsDao;

import static com.movie.maotrailer.db.MaoDatabase.VERSION;

@Database(entities = {FavoriteThings.class}, version = VERSION, exportSchema = false)
public abstract class MaoDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract FavoriteThingsDao favoriteThingsDao();
}
