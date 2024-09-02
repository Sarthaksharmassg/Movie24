package com.example.movies24.movieList.domain.repository
import com.example.movies24.movieList.domain.model.Movie
import com.example.movies24.movieList.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository{
    suspend fun getMovieListIsInRepo(
         forceFetchFromRemote: Boolean,
         category:String,
         page:Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id:Int):Flow<Resource<Movie>>

}