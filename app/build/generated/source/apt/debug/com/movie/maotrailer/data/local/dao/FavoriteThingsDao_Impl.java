package com.movie.maotrailer.data.local.dao;

import android.arch.paging.DataSource;
import android.arch.paging.DataSource.Factory;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.arch.persistence.room.paging.LimitOffsetDataSource;
import android.database.Cursor;
import com.movie.maotrailer.data.local.entity.FavoriteThings;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class FavoriteThingsDao_Impl implements FavoriteThingsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfFavoriteThings;

  private final SharedSQLiteStatement __preparedStmtOfDeleteItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FavoriteThingsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavoriteThings = new EntityInsertionAdapter<FavoriteThings>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `favorite_things`(`id`,`iid`,`poster`,`year`,`name`,`vote`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavoriteThings value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIid());
        if (value.getPoster() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPoster());
        }
        if (value.getYear() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getYear());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        stmt.bindDouble(6, value.getVote());
      }
    };
    this.__preparedStmtOfDeleteItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM favorite_things WHERE iid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM favorite_things";
        return _query;
      }
    };
  }

  @Override
  public void insertItem(FavoriteThings favoriteThings) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavoriteThings.insert(favoriteThings);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteItem(int iid) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteItem.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, iid);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteItem.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public DataSource.Factory<Integer, FavoriteThings> getAll() {
    final String _sql = "SELECT * FROM favorite_things";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, FavoriteThings>() {
      @Override
      public LimitOffsetDataSource<FavoriteThings> create() {
        return new LimitOffsetDataSource<FavoriteThings>(__db, _statement, false , "favorite_things") {
          @Override
          protected List<FavoriteThings> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = cursor.getColumnIndexOrThrow("id");
            final int _cursorIndexOfIid = cursor.getColumnIndexOrThrow("iid");
            final int _cursorIndexOfPoster = cursor.getColumnIndexOrThrow("poster");
            final int _cursorIndexOfYear = cursor.getColumnIndexOrThrow("year");
            final int _cursorIndexOfName = cursor.getColumnIndexOrThrow("name");
            final int _cursorIndexOfVote = cursor.getColumnIndexOrThrow("vote");
            final List<FavoriteThings> _res = new ArrayList<FavoriteThings>(cursor.getCount());
            while(cursor.moveToNext()) {
              final FavoriteThings _item;
              final int _tmpIid;
              _tmpIid = cursor.getInt(_cursorIndexOfIid);
              final String _tmpPoster;
              _tmpPoster = cursor.getString(_cursorIndexOfPoster);
              final String _tmpYear;
              _tmpYear = cursor.getString(_cursorIndexOfYear);
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final float _tmpVote;
              _tmpVote = cursor.getFloat(_cursorIndexOfVote);
              _item = new FavoriteThings(_tmpIid,_tmpPoster,_tmpYear,_tmpName,_tmpVote);
              final int _tmpId;
              _tmpId = cursor.getInt(_cursorIndexOfId);
              _item.setId(_tmpId);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public int getItemById(int iid) {
    final String _sql = "SELECT iid FROM favorite_things WHERE iid = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, iid);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
