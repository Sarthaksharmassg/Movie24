package com.example.movies24.movieList.util

sealed class Screen(val rout: String) {
    object Home: Screen("main")
    object Top_RatedMovieList : Screen("top_ratedMovie")
    object UpcomingMoviesList : Screen("upcomingMovie")
    object Details:Screen("details")
}