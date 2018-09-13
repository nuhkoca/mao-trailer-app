package com.movie.maotrailer.callback;

import android.widget.ImageView;

public interface IItemClickListener<Result> {
    void onItemClick(Result result, ImageView imageView);
}
