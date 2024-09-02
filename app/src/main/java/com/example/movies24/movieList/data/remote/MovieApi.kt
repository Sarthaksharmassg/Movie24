package com.example.movies24.movieList.data.remote

import com.example.movies24.movieList.data.remote.respond.MovieListDTO
import com.example.movies24.movieList.data.remote.respond.MovieResultDetails
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/{category}")  //Top-Rated, Popular Upcoming etc
    suspend fun getMovieListIsInRetrofitMovieApi(
    @Path("category") category : String,
    @Query("page") page: Int,
    @Query("Key") apiKey: String =API_KEY
    ):MovieListDTO
    companion object{
        const val BASE_URL="https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL= "https://image.tmdb.org/t/p/w500/"
        const val API_KEY="91be061d01d3e2011660cb5068eba830"
    }
}
