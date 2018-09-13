package com.movie.maotrailer.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.movie.maotrailer.data.local.dao.FavoriteThingsDao;
import com.movie.maotrailer.data.local.dao.FavoriteThingsDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class MaoDatabase_Impl extends MaoDatabase {
  private volatile FavoriteThingsDao _favoriteThingsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favorite_things` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `iid` INTEGER NOT NULL, `poster` TEXT, `year` TEXT, `name` TEXT, `vote` REAL NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX `index_favorite_things_iid` ON `favorite_things` (`iid`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"7c2ba9ca9e3dad79987be1f8b5f3bb12\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `favorite_things`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFavoriteThings = new HashMap<String, TableInfo.Column>(6);
        _columnsFavoriteThings.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsFavoriteThings.put("iid", new TableInfo.Column("iid", "INTEGER", true, 0));
        _columnsFavoriteThings.put("poster", new TableInfo.Column("poster", "TEXT", false, 0));
        _columnsFavoriteThings.put("year", new TableInfo.Column("year", "TEXT", false, 0));
        _columnsFavoriteThings.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsFavoriteThings.put("vote", new TableInfo.Column("vote", "REAL", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavoriteThings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavoriteThings = new HashSet<TableInfo.Index>(1);
        _indicesFavoriteThings.add(new TableInfo.Index("index_favorite_things_iid", true, Arrays.asList("iid")));
        final TableInfo _infoFavoriteThings = new TableInfo("favorite_things", _columnsFavoriteThings, _foreignKeysFavoriteThings, _indicesFavoriteThings);
        final TableInfo _existingFavoriteThings = TableInfo.read(_db, "favorite_things");
        if (! _infoFavoriteThings.equals(_existingFavoriteThings)) {
          throw new IllegalStateException("Migration didn't properly handle favorite_things(com.movie.maotrailer.data.local.FavoriteThings).\n"
                  + " Expected:\n" + _infoFavoriteThings + "\n"
                  + " Found:\n" + _existingFavoriteThings);
        }
      }
    }, "7c2ba9ca9e3dad79987be1f8b5f3bb12", "197ff68e5befff50ec68e32abcd8adf2");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "favorite_things");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `favorite_things`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public FavoriteThingsDao favoriteThingsDao() {
    if (_favoriteThingsDao != null) {
      return _favoriteThingsDao;
    } else {
      synchronized(this) {
        if(_favoriteThingsDao == null) {
          _favoriteThingsDao = new FavoriteThingsDao_Impl(this);
        }
        return _favoriteThingsDao;
      }
    }
  }
}
