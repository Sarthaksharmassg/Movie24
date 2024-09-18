// Generated by Dagger (https://dagger.dev).
package com.example.movies24.movieList.data.repository;

import com.example.movies24.movieList.data.movie.MovieDatabase;
import com.example.movies24.movieList.data.remote.MovieApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class MovieListRepositoryImplmn_Factory implements Factory<MovieListRepositoryImplmn> {
  private final Provider<MovieApi> movieApiProvider;

  private final Provider<MovieDatabase> movieDatabaseProvider;

  public MovieListRepositoryImplmn_Factory(Provider<MovieApi> movieApiProvider,
      Provider<MovieDatabase> movieDatabaseProvider) {
    this.movieApiProvider = movieApiProvider;
    this.movieDatabaseProvider = movieDatabaseProvider;
  }

  @Override
  public MovieListRepositoryImplmn get() {
    return newInstance(movieApiProvider.get(), movieDatabaseProvider.get());
  }

  public static MovieListRepositoryImplmn_Factory create(Provider<MovieApi> movieApiProvider,
      Provider<MovieDatabase> movieDatabaseProvider) {
    return new MovieListRepositoryImplmn_Factory(movieApiProvider, movieDatabaseProvider);
  }

  public static MovieListRepositoryImplmn newInstance(MovieApi movieApi,
      MovieDatabase movieDatabase) {
    return new MovieListRepositoryImplmn(movieApi, movieDatabase);
  }
}
