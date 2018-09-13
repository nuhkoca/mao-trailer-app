package com.movie.maotrailer.binding;

import android.databinding.BindingAdapter;
import android.util.SparseArray;
import android.widget.TextView;

import com.movie.maotrailer.R;

import java.util.List;

public class GenreBindingAdapter {

    @BindingAdapter(value = {"android:genre"})
    public static void bindGenre(TextView dest, List<Integer> genreList) {
        SparseArray<String> genres = new SparseArray<>(); //much more effective in case key-value pairing

        for (int i = 0; i < dest.getContext().getResources().getIntArray(R.array.genreIds).length; i++) {
            genres.append(dest.getContext().getResources().getIntArray(R.array.genreIds)[i],
                    dest.getContext().getResources().getStringArray(R.array.genreLabels)[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer id : genreList) {
            stringBuilder.append(genres.get(id)).append(", ");
        }

        //delete last comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        dest.setText(stringBuilder.toString());
    }
}
