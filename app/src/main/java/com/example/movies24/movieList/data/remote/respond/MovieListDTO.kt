package com.example.movies24.movieList.data.remote.respond

data class MovieListDTO(
    val page: Int,
    val results: List<MovieResultDetails>,
    val total_pages: Int,
    val total_results: Int
)