package com.example.movies24
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import com.example.movies24.movieList.vM.MovieViewModel
//import androidx.lifecycle.viewmodel.compose.viewModel

//@Composable
//fun MoviesScreen(viewModel:MovieViewModel = viewModel()){
//    val moviesAll by viewModel.movies.collectAsState() //SearchPT
//    LaunchedEffect(key1 = Unit) {
//        println("Composable Test")
//        viewModel.fetchMoviesByCategory("popular")
//    }
//    Column() {
//        if(moviesAll.isEmpty()){
//            println("Not fetched anything")
//        }
//        else {
//            for (movie in moviesAll) {
//
//                println("Response is ${movie.original_title}")
//            }
//        }
//    }
//}