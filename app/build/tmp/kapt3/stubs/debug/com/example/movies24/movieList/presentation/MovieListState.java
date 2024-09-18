package com.example.movies24.movieList.presentation;

import com.example.movies24.movieList.domain.model.Movie;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003JQ\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/example/movies24/movieList/presentation/MovieListState;", "", "isLoading", "", "top_RatedMovieListPage", "", "upcomingMovieListPage", "isCurrentScreenTop_Rated", "top_RatedMovieList", "", "Lcom/example/movies24/movieList/domain/model/Movie;", "upcomingMovieList", "(ZIIZLjava/util/List;Ljava/util/List;)V", "()Z", "getTop_RatedMovieList", "()Ljava/util/List;", "getTop_RatedMovieListPage", "()I", "getUpcomingMovieList", "getUpcomingMovieListPage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class MovieListState {
    private final boolean isLoading = false;
    private final int top_RatedMovieListPage = 0;
    private final int upcomingMovieListPage = 0;
    private final boolean isCurrentScreenTop_Rated = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.movies24.movieList.domain.model.Movie> top_RatedMovieList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.movies24.movieList.domain.model.Movie> upcomingMovieList = null;
    
    public MovieListState(boolean isLoading, int top_RatedMovieListPage, int upcomingMovieListPage, boolean isCurrentScreenTop_Rated, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.movies24.movieList.domain.model.Movie> top_RatedMovieList, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.movies24.movieList.domain.model.Movie> upcomingMovieList) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final int getTop_RatedMovieListPage() {
        return 0;
    }
    
    public final int getUpcomingMovieListPage() {
        return 0;
    }
    
    public final boolean isCurrentScreenTop_Rated() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.movies24.movieList.domain.model.Movie> getTop_RatedMovieList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.movies24.movieList.domain.model.Movie> getUpcomingMovieList() {
        return null;
    }
    
    public MovieListState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.movies24.movieList.domain.model.Movie> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.movies24.movieList.domain.model.Movie> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.movies24.movieList.presentation.MovieListState copy(boolean isLoading, int top_RatedMovieListPage, int upcomingMovieListPage, boolean isCurrentScreenTop_Rated, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.movies24.movieList.domain.model.Movie> top_RatedMovieList, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.movies24.movieList.domain.model.Movie> upcomingMovieList) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}