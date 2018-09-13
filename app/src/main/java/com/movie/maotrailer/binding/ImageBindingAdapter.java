package com.movie.maotrailer.binding;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.movie.maotrailer.BuildConfig;
import com.movie.maotrailer.di.MaoGlide;

public class ImageBindingAdapter {

    @BindingAdapter(value = {"android:src", "android:cv"})
    public static void bindImage(ImageView dest, String url, CardView cardView) {
        if (!TextUtils.isEmpty(url)) {
            MaoGlide.with(dest.getContext())
                    .asBitmap()
                    .load(BuildConfig.ImagePath + url)
                    .disallowHardwareConfig()
                    .listener(new RequestListener<Bitmap>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                            Palette.from(resource).generate(palette -> {
                                if (palette.getDominantSwatch() != null) {
                                    cardView.setBackgroundColor(palette.getDominantSwatch().getRgb());
                                }
                            });

                            return false;
                        }
                    })
                    .into(dest);
        }
    }

    @BindingAdapter(value = {"android:src"})
    public static void bindImage(ImageView dest, String url) {
        if (!TextUtils.isEmpty(url)) {
            MaoGlide.with(dest.getContext())
                    .asBitmap()
                    .load(BuildConfig.ImagePath + url)
                    .disallowHardwareConfig()
                    .into(dest);
        }
    }
}
