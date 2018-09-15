package com.movie.maotrailer.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import com.movie.maotrailer.helper.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ColumnUtils {

    private Context context;

    @Inject
    ColumnUtils(Context context) {
        this.context = context;
    }

    public int getOptimalNumberOfColumn(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int widthDivider = Constants.DEFAULT_COLUMN_WIDTH;

        if (context != null) {
            int width = displayMetrics.widthPixels;
            int nColumns = width / widthDivider;
            if (nColumns < 2) return 2;
            return nColumns;
        }

        return 2;
    }
}