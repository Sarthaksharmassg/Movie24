package com.example.movies24.movieList.presentation

import androidx.lifecycle.ViewModel
import com.example.movies24.movieList.domain.repository.MovieListRepository
import com.example.movies24.movieList.util.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieListRepository : MovieListRepository
) : ViewModel(){
    private var _movieListState= MutableStateFlow(MovieListState())
    val movieListState= _movieListState.asStateFlow()
    init{
        getTop_RatedMovieList(false)
        getUpcomingMoviesList(false)
    }

    private fun onEvent(event:MovieListUIEvent){
        when(event){
            MovieListUIEvent.Navigate ->{
                _movieListState.update{
                    it.copy(
                        isCurrentScreenTop_Rated = !movieListState.value.isCurrentScreenTop_Rated
                    )
                }
            }
            is MovieListUIEvent.Paginate -> {
                if(event.category==Category.TOP_RATED){
                    getTop_RatedMovieList(true)
                }
                else if(event.category==Category.UPCOMING){
                    getUpcomingMoviesList(true)
                }
            }
        }
    }
    private fun getTop_RatedMovieList(forceFetchFromRemote: Boolean){}    //While Paginating we have to force fetch from API otherwise we check if in database and fetch from there



    private fun getUpcomingMoviesList(forceFetchFromRemote: Boolean){}

}

