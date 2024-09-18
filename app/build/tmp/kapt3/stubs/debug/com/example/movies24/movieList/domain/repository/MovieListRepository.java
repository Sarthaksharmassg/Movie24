package com.example.movies24.movieList.domain.repository;

import com.example.movies24.movieList.domain.model.Movie;
import com.example.movies24.movieList.util.Resource;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ;\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/movies24/movieList/domain/repository/MovieListRepository;", "", "getMovie", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/movies24/movieList/util/Resource;", "Lcom/example/movies24/movieList/domain/model/Movie;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieListIsInRepo", "", "forceFetchFromRemote", "", "category", "", "page", "(ZLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MovieListRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieListIsInRepo(boolean forceFetchFromRemote, @org.jetbrains.annotations.NotNull
    java.lang.String category, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.movies24.movieList.util.Resource<java.util.List<com.example.movies24.movieList.domain.model.Movie>>>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovie(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.movies24.movieList.util.Resource<com.example.movies24.movieList.domain.model.Movie>>> $completion);
}