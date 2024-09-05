package com.example.movies24.movieList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies24.movieList.domain.repository.MovieListRepository
import com.example.movies24.movieList.util.Category
import com.example.movies24.movieList.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
    private fun getTop_RatedMovieList(forceFetchFromRemote: Boolean){
        viewModelScope.launch {
            _movieListState.update{
                it.copy(isLoading=true)
            }
            movieListRepository.getMovieListIsInRepo(
                forceFetchFromRemote,
                Category.TOP_RATED,
                movieListState.value.top_RatedMovieListPage
            ).collectLatest {
                result->
                when(result){
                    is Resource.Error ->{
                        _movieListState.update{
                            it.copy(isLoading=false)
                        }
                    }

                    is Resource.Success ->{
                        result.data?.let{ topRatedList->
                            _movieListState.update{
                                it.copy(
                                    top_RatedMovieList = movieListState.value.top_RatedMovieList
                                    +topRatedList.shuffled(),
                                    top_RatedMovieListPage = movieListState.value.top_RatedMovieListPage+1
                                )
                            }

                        }
                    }
                    is Resource.Loading ->{
                        _movieListState.update{
                            it.copy(isLoading=result.isLoading)
                        }
                    }
                }
            }
        }
    }    //While Paginating we have to force fetch from API otherwise we check if in database and fetch from there



    private fun getUpcomingMoviesList(forceFetchFromRemote: Boolean){
        viewModelScope.launch {
            _movieListState.update{
                it.copy(isLoading=true)
            }
            movieListRepository.getMovieListIsInRepo(
                forceFetchFromRemote,
                Category.UPCOMING,
                movieListState.value.upcomingMovieListPage
            ).collectLatest {
                    result->
                when(result){
                    is Resource.Error ->{
                        _movieListState.update{
                            it.copy(isLoading=false)
                        }
                    }

                    is Resource.Success ->{
                        result.data?.let{ upcomingList->
                            _movieListState.update{
                                it.copy(
                                    upcomingMovieList = movieListState.value.upcomingMovieList
                                            +upcomingList.shuffled(),
                                    upcomingMovieListPage = movieListState.value.upcomingMovieListPage +1
                                )
                            }

                        }
                    }
                    is Resource.Loading ->{
                        _movieListState.update{
                            it.copy(isLoading=result.isLoading)
                        }
                    }
                }
            }
        }
    }

}

