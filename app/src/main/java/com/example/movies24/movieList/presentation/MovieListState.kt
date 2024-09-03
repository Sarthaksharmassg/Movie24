package com.example.movies24.movieList.presentation

import com.example.movies24.movieList.domain.model.Movie

data class MovieListState (    //Purpose?
    val isLoading: Boolean=false,
    val top_RatedMovieListPage:Int=1,
    val upcomingMovieListPage:Int=1,
    val isCurrentScreenTop_Rated:Boolean=true,

    val top_RatedMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList()
)
