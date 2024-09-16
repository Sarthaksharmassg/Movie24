package com.example.movies24.movieList.presentation;

import androidx.lifecycle.ViewModel;
import com.example.movies24.movieList.data.remote.MovieApi;
import com.example.movies24.movieList.domain.repository.MovieListRepository;
import com.example.movies24.movieList.util.Category;
import com.example.movies24.movieList.util.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/example/movies24/movieList/presentation/MovieListViewModel;", "Landroidx/lifecycle/ViewModel;", "movieListRepository", "Lcom/example/movies24/movieList/domain/repository/MovieListRepository;", "movieApi", "Lcom/example/movies24/movieList/data/remote/MovieApi;", "(Lcom/example/movies24/movieList/domain/repository/MovieListRepository;Lcom/example/movies24/movieList/data/remote/MovieApi;)V", "_movieListState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/movies24/movieList/presentation/MovieListState;", "movieListState", "Lkotlinx/coroutines/flow/StateFlow;", "getMovieListState", "()Lkotlinx/coroutines/flow/StateFlow;", "getTop_RatedMovieList", "", "forceFetchFromRemote", "", "getUpcomingMoviesList", "onEvent", "event", "Lcom/example/movies24/movieList/presentation/MovieListUIEvent;", "test", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.movies24.movieList.domain.repository.MovieListRepository movieListRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.movies24.movieList.data.remote.MovieApi movieApi = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.example.movies24.movieList.presentation.MovieListState> _movieListState;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.movies24.movieList.presentation.MovieListState> movieListState = null;
    
    @javax.inject.Inject
    public MovieListViewModel(@org.jetbrains.annotations.NotNull
    com.example.movies24.movieList.domain.repository.MovieListRepository movieListRepository, @org.jetbrains.annotations.NotNull
    com.example.movies24.movieList.data.remote.MovieApi movieApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.movies24.movieList.presentation.MovieListState> getMovieListState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.example.movies24.movieList.presentation.MovieListUIEvent event) {
    }
    
    private final void getTop_RatedMovieList(boolean forceFetchFromRemote) {
    }
    
    private final void getUpcomingMoviesList(boolean forceFetchFromRemote) {
    }
    
    private final void test() {
    }
}