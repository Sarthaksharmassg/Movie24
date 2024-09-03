package com.example.movies24.movieList.presentation

sealed interface MovieListUIEvent {
    data class Paginate(val category: String):MovieListUIEvent
    object Navigate : MovieListUIEvent
}