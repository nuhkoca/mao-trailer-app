package com.movie.maotrailer.data.local.repository;

import android.arch.paging.DataSource;
import android.os.AsyncTask;

import com.movie.maotrailer.data.local.entity.FavoriteThings;
import com.movie.maotrailer.data.local.IRoomProgressListener;
import com.movie.maotrailer.data.local.dao.FavoriteThingsDao;
import com.movie.maotrailer.helper.AppsExecutor;

import javax.inject.Inject;

public class FavoriteThingsRepository {

    private FavoriteThingsDao favoriteThingsDao;
    private AppsExecutor appsExecutor;

    @Inject
    public FavoriteThingsRepository(FavoriteThingsDao favoriteThingsDao, AppsExecutor appsExecutor) {
        this.favoriteThingsDao = favoriteThingsDao;
        this.appsExecutor = appsExecutor;

    }

    public DataSource.Factory<Integer, FavoriteThings> getAll() {
        return favoriteThingsDao.getAll();
    }

    public void insertOrThrow(FavoriteThings favoriteThings, int tid, IRoomProgressListener iRoomProgressListener) {
        new insertOrThrowAsync(tid, favoriteThingsDao, iRoomProgressListener).execute(favoriteThings);
    }

    public void deleteItem(final int iid) {
        appsExecutor.diskIO().execute(() -> favoriteThingsDao.deleteItem(iid));
    }

    public void deleteAll() {
        appsExecutor.diskIO().execute(() -> favoriteThingsDao.deleteAll());
    }

    private static class insertOrThrowAsync extends AsyncTask<FavoriteThings, Void, Boolean> {

        private int iid;
        private FavoriteThingsDao favoriteThingsDao;
        private IRoomProgressListener iRoomProgressListener;

        insertOrThrowAsync(int iid, FavoriteThingsDao favoriteThingsDao, IRoomProgressListener iRoomProgressListener) {
            this.iid = iid;
            this.favoriteThingsDao = favoriteThingsDao;
            this.iRoomProgressListener = iRoomProgressListener;
        }

        @Override
        protected Boolean doInBackground(FavoriteThings... favoriteThings) {
            if (iid == favoriteThingsDao.getItemById(iid)) {
                return true;
            } else {
                favoriteThingsDao.insertItem(favoriteThings[0]);
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            iRoomProgressListener.onItemReceived(result);
        }
    }
}
