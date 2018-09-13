package com.movie.maotrailer.di.module;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import com.movie.maotrailer.data.local.dao.FavoriteThingsDao;
import com.movie.maotrailer.db.MaoDatabase;
import com.movie.maotrailer.helper.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    Migration provideMigration(){
        return new Migration(Constants.DB_START_VERSION, Constants.DB_END_VERSION) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {
                //No change atm
            }
        };
    }

    @Provides
    @Singleton
    MaoDatabase provideMaoDatabase(Application application, Migration migration){
        return Room.databaseBuilder(application, MaoDatabase.class, Constants.MAO_DATABASE_NAME)
                .addMigrations(migration)
                .build();
    }

    @Provides
    FavoriteThingsDao provideFavoriteThingsDao(MaoDatabase maoDatabase){
        return maoDatabase.favoriteThingsDao();
    }
}
