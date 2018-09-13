package com.movie.maotrailer.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class RatingBindingAdapter {

    @BindingAdapter(value = {"android:rating"})
    public static void bindRating(TextView dest, float rating) {
        if (!Float.isNaN(rating)) {
            dest.setText(String.valueOf(rating));
        }
    }
}
