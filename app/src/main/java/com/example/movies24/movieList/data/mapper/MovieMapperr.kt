//package com.example.movies24.movieList.data.mapper
//
//import com.example.movies24.movieList.data.movie.MovieEntity
//import com.example.movies24.movieList.domain.model.Movie
//
//fun MovieEntity.toMovie(
//    category:String
//): Movie{
//    return Movie(
//        backdrop_path=backdrop_path,
//        original_language = original_language,
//        overview = overview,
//        poster_path = poster_path,
//        release_date = release_date,
//        title = title,
//        vote_average = vote_average,
//        popularity = popularity,
//        vote_count = vote_count,
//        video = video,
//        id = id,
//        adult = adult,
//        original_title = original_title,
//
//        category = category,
//        genre_ids = try{
//            genre_ids.split(",")
//        }
//    )
//}