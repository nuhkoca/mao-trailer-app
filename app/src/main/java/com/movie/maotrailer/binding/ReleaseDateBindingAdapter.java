package com.movie.maotrailer.binding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.TextView;

public class ReleaseDateBindingAdapter {

    @BindingAdapter(value = {"android:date"})
    public static void bindReleaseDate(TextView dest, String date) {
        if (!TextUtils.isEmpty(date)) {
            dest.setText(date.substring(0, 4));
        }
    }
}
