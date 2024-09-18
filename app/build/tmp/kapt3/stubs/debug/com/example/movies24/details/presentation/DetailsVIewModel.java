package com.example.movies24.details.presentation;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.movies24.movieList.domain.repository.MovieListRepository;
import com.example.movies24.movieList.presentation.MovieListState;
import com.example.movies24.movieList.util.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/example/movies24/details/presentation/DetailsVIewModel;", "Landroidx/lifecycle/ViewModel;", "movieListRepository", "Lcom/example/movies24/movieList/domain/repository/MovieListRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/movies24/movieList/domain/repository/MovieListRepository;Landroidx/lifecycle/SavedStateHandle;)V", "_detailsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/movies24/details/presentation/DetailsState;", "detailsState", "Lkotlinx/coroutines/flow/StateFlow;", "getDetailsState", "()Lkotlinx/coroutines/flow/StateFlow;", "movieId", "", "Ljava/lang/Integer;", "getMovieListRepository", "()Lcom/example/movies24/movieList/domain/repository/MovieListRepository;", "getSavedStateHandle", "()Landroidx/lifecycle/SavedStateHandle;", "getMovie", "", "id", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DetailsVIewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.movies24.movieList.domain.repository.MovieListRepository movieListRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer movieId = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.example.movies24.details.presentation.DetailsState> _detailsState;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.movies24.details.presentation.DetailsState> detailsState = null;
    
    @javax.inject.Inject
    public DetailsVIewModel(@org.jetbrains.annotations.NotNull
    com.example.movies24.movieList.domain.repository.MovieListRepository movieListRepository, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.movies24.movieList.domain.repository.MovieListRepository getMovieListRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.SavedStateHandle getSavedStateHandle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.movies24.details.presentation.DetailsState> getDetailsState() {
        return null;
    }
    
    private final void getMovie(int id) {
    }
}