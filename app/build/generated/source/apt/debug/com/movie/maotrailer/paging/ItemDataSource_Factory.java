// Generated by Dagger (https://google.github.io/dagger).
package com.movie.maotrailer.paging;

import com.movie.maotrailer.api.repository.EndpointRepository;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

public final class ItemDataSource_Factory implements Factory<ItemDataSource> {
  private final Provider<EndpointRepository> endpointRepositoryProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public ItemDataSource_Factory(
      Provider<EndpointRepository> endpointRepositoryProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    this.endpointRepositoryProvider = endpointRepositoryProvider;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public ItemDataSource get() {
    return provideInstance(endpointRepositoryProvider, compositeDisposableProvider);
  }

  public static ItemDataSource provideInstance(
      Provider<EndpointRepository> endpointRepositoryProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new ItemDataSource(endpointRepositoryProvider.get(), compositeDisposableProvider.get());
  }

  public static ItemDataSource_Factory create(
      Provider<EndpointRepository> endpointRepositoryProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new ItemDataSource_Factory(endpointRepositoryProvider, compositeDisposableProvider);
  }

  public static ItemDataSource newItemDataSource(
      EndpointRepository endpointRepository, CompositeDisposable compositeDisposable) {
    return new ItemDataSource(endpointRepository, compositeDisposable);
  }
}
