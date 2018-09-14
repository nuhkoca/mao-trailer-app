package com.movie.maotrailer.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.util.DiffUtil;

@Entity(tableName = "favorite_things", indices = {@Index(value = "iid", unique = true)})
public class FavoriteThings {

    public static DiffUtil.ItemCallback<FavoriteThings> DIFF_CALLBACK = new DiffUtil.ItemCallback<FavoriteThings>() {
        @Override
        public boolean areItemsTheSame(FavoriteThings oldItem, FavoriteThings newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(FavoriteThings oldItem, FavoriteThings newItem) {
            return oldItem.equals(newItem);
        }
    };

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "iid")
    private int iid;
    @ColumnInfo(name = "poster")
    private String poster;
    @ColumnInfo(name = "year")
    private String year;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "vote")
    private float vote;

    public FavoriteThings(int iid, String poster, String year, String name, float vote) {
        this.iid = iid;
        this.poster = poster;
        this.year = year;
        this.name = name;
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() == obj.getClass()) {
            return true;
        }

        FavoriteThings favoriteThings = (FavoriteThings) obj;

        return favoriteThings.id == this.id;
    }
}
