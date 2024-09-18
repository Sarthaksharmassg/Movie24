package com.example.movies24.movieList.presentation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies24.movieList.data.remote.MovieApi
import com.example.movies24.movieList.domain.repository.MovieListRepository
import com.example.movies24.movieList.util.Category
import com.example.movies24.movieList.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.movies24.movieList.data.movie.MovieDao
@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieListRepository : MovieListRepository,
    private val movieApi: MovieApi
) : ViewModel(){
    private var _movieListState= MutableStateFlow(MovieListState())
    val movieListState= _movieListState.asStateFlow()


    init{
        refreshpull()
        getTop_RatedMovieList(false)
        getUpcomingMoviesList(false)
    }

    fun onEvent(event:MovieListUIEvent){
        when(event){
            MovieListUIEvent.Navigate ->{
                _movieListState.update{      //Mutablestatefunction if current val not equal to next value then set taks a function as paramter
                    it.copy(                //copy(): A function that is available on data classes in Kotlin. It allows you to create a new instance of the data class by copying the current instance (i.e., it) and changing only the properties you specify. All other properties will retain the values of the original instance.
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
            }    //todo SEARCH
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


    private fun test() {
        viewModelScope.launch {
            movieApi.getMovieListIsInRetrofitMovieApi("upcoming", 1) //DECLARED IN MOVIEAPI GET CALL

        }

    }

    private val _isRefreshing= MutableStateFlow(false)
    val isRefrshing:StateFlow<Boolean>
        get()=_isRefreshing.asStateFlow()

    fun refreshpull(){
        viewModelScope.launch{
        //var forcefetch: Boolean= true;
            movieListRepository.getMovieListIsInRepo(
                true,
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
                                    upcomingMovieList =upcomingList.shuffled(),
                                    upcomingMovieListPage =1
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
            _isRefreshing.emit(false)
        }
    }

}

