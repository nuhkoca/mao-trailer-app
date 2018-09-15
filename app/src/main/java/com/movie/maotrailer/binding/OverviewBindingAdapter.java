package com.movie.maotrailer.binding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.TextView;

import com.movie.maotrailer.R;

public class OverviewBindingAdapter {

    @BindingAdapter(value = {"android:overview"})
    public static void bindOverview(TextView dest, String overview) {
        if (!TextUtils.isEmpty(overview) || !overview.equals(" ")) {
            dest.setText(overview);
        } else {
            dest.setText(dest.getContext().getString(R.string.no_overview_info_found));
        }
    }
}
