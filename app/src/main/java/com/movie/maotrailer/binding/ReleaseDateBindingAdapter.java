package com.movie.maotrailer.binding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.TextView;

import com.movie.maotrailer.R;

public class ReleaseDateBindingAdapter {

    @BindingAdapter(value = {"android:date"})
    public static void bindReleaseDate(TextView dest, String date) {
        if (!TextUtils.isEmpty(date)) {
            dest.setText(date.substring(0, 4));
        } else {
            dest.setText(dest.getContext().getString(R.string.no_date_info_found));
        }
    }
}
