package com.example.movies24.movieList.data.repository

import com.example.movies24.movieList.data.mapper.toMovie
import com.example.movies24.movieList.data.mapper.toMovieEntity
import com.example.movies24.movieList.data.movie.MovieDatabase
import com.example.movies24.movieList.data.movie.MovieEntity
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
            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)  //THis cals moviebycate which must have the api function declared in interface if response empty then its ftched form db
            val shouldgetfromlocalDb = localMovieList.isNotEmpty() && !forceFetchFromRemote


            //TODO Pls uncomment while creating mappers
            if(shouldgetfromlocalDb){
                emit(Resource.Success(
                    data=localMovieList.map{
                        movieEntity ->  movieEntity.toMovie(category)
                    }
                ))
                emit(Resource.Loading(false))
                return@flow
            }
            val movieListFromApi= try{
                movieApi.getMovieListIsInRetrofitMovieApi(category, page) //DECLARED IN MOVIEAPI GET CALL
            }
            catch(e:Exception){
                e.printStackTrace()
                emit(Resource.Error(message= "Error loading page"))  //Simple error handling
                return@flow
            }
            val movieEntitiess = movieListFromApi.results.let{
                it.map{movieResultDetails -> movieResultDetails.toMovieEntity(category)}
            }

            movieDatabase.movieDao.upsertMovieList(movieEntitiess)  //Storing in the database

            emit(Resource.Success(movieEntitiess.map{it.toMovie(category)}))
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
       return flow{
           emit(Resource.Loading(true))
           val movieEntity = movieDatabase.movieDao.getMovieById(id)
           if(movieEntity!=null){
               emit(Resource.Success(movieEntity.toMovie(movieEntity.category))
               )
               emit(Resource.Loading(isLoading = false))
               return@flow
           }
           emit(Resource.Error("Error it is, movie no - Yoda"))

       }
    }

}