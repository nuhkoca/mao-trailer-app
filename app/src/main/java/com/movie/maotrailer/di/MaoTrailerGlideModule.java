package com.movie.maotrailer.di;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

@GlideModule(glideName = "MaoGlide")
public class MaoTrailerGlideModule extends AppGlideModule {

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        OkHttpUrlLoader.Factory factory = new OkHttpUrlLoader.Factory(client);

        glide.getRegistry().replace(GlideUrl.class, InputStream.class, factory);
    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        int memoryCacheSizeBytes = 1024 * 1024 * 300; // 300mb cache
        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, memoryCacheSizeBytes));
        builder.setDefaultRequestOptions(requestOptions(context));
    }

    private RequestOptions requestOptions(Context context) {
        return new RequestOptions()
                .signature(new ObjectKey(
                        System.currentTimeMillis() / (168 * 60 * 60 * 1000))) // 1 week cache
                .encodeFormat(Bitmap.CompressFormat.PNG)
                .encodeQuality(100)
                .override(Target.SIZE_ORIGINAL)
                //.placeholder(ContextCompat.getDrawable(context, R.drawable.ic_placeholder))
                //.error(ContextCompat.getDrawable(context, R.drawable.ic_placeholder))
                .error(new ColorDrawable(Color.GRAY))
                .fallback(new ColorDrawable(Color.GRAY))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .format(PREFER_ARGB_8888) //since O+ devices throw error when using Palette
                .fitCenter()
                .dontAnimate()
                .skipMemoryCache(false);
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
