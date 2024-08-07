// Generated by Dagger (https://google.github.io/dagger).
package com.movie.maotrailer.di.module;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class NetModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<Gson> gsonProvider;

  public NetModule_ProvideRetrofitFactory(
      NetModule module, Provider<OkHttpClient> okHttpClientProvider, Provider<Gson> gsonProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return provideInstance(module, okHttpClientProvider, gsonProvider);
  }

  public static Retrofit provideInstance(
      NetModule module, Provider<OkHttpClient> okHttpClientProvider, Provider<Gson> gsonProvider) {
    return proxyProvideRetrofit(module, okHttpClientProvider.get(), gsonProvider.get());
  }

  public static NetModule_ProvideRetrofitFactory create(
      NetModule module, Provider<OkHttpClient> okHttpClientProvider, Provider<Gson> gsonProvider) {
    return new NetModule_ProvideRetrofitFactory(module, okHttpClientProvider, gsonProvider);
  }

  public static Retrofit proxyProvideRetrofit(
      NetModule instance, OkHttpClient okHttpClient, Gson gson) {
    return Preconditions.checkNotNull(
        instance.provideRetrofit(okHttpClient, gson),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
