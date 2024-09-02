package com.example.movies24.movieList.data.repository

import com.example.movies24.movieList.data.movie.MovieDatabase
import com.example.movies24.movieList.data.remote.MovieApi
import com.example.movies24.movieList.domain.model.Movie
import com.example.movies24.movieList.domain.repository.MovieListRepository
import com.example.movies24.movieList.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepositoryImplmn @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
)
: MovieListRepository {
    override suspend fun getMovieListIsInRepo(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int,
    ): Flow<Resource<List<Movie>>> {
        return flow{
            emit(Resource.Loading(true))
            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)
            val shouldgetfromlocalDb = localMovieList.isNotEmpty() && !forceFetchFromRemote


            //TODO Pls uncomment while creating mappers
//            if(shouldgetfromlocalDb){
//                emit(Resource.Success(
//                    data=localMovieList
//                ))
//            }
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        TODO("Not yet implemented")
    }

}