package com.example.movies24.details.presentation

import com.example.movies24.movieList.domain.model.Movie

data class DetailsState(
     var isLoading: Boolean=false,
     val movie: Movie?=null
)
