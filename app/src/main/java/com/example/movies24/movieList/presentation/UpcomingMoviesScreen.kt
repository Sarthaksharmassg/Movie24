package com.example.movies24.movieList.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies24.movieList.presentation.component.MovieItem
import com.example.movies24.movieList.util.Category
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpcomingMoviesScreen(
    movieListState: MovieListState,
    navController: NavController,
    onEvent:(MovieListUIEvent)->Unit

){

    if(movieListState.upcomingMovieList.isEmpty()){
        Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    else{
        Box(modifier =Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
            ) {
                items(movieListState.upcomingMovieList.size) { index ->
                    MovieItem(
                        movie = movieListState.upcomingMovieList[index],
                        navHostController = navController
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    if ((index >= movieListState.upcomingMovieList.size - 1) && !movieListState.isLoading) {
                        onEvent(MovieListUIEvent.Paginate(Category.UPCOMING))
                    }
                }
            }
        }
    }
}
//    private val _isRefreshing= MutableStateFlow(false)
//    val isRefrshing:StateFlow<Boolean>
//        get()=_isRefreshing.asStateFlow()
//
//    fun refreshpull(){
//        viewModelScope.launch{
//        //var forcefetch: Boolean= true;
//            movieListRepository.getMovieListIsInRepo(
//                true,
//                Category.UPCOMING,
//                movieListState.value.upcomingMovieListPage
//            ).collectLatest {
//                    result->
//                when(result){
//                    is Resource.Error ->{
//                        _movieListState.update{
//                            it.copy(isLoading=false)
//                        }
//                    }
//
//                    is Resource.Success ->{
//                        result.data?.let{ upcomingList->
//                            _movieListState.update{
//                                it.copy(
//                                    upcomingMovieList =upcomingList.shuffled(),
//                                    upcomingMovieListPage =1
//                                )
//                            }
//
//                        }
//                    }
//                    is Resource.Loading ->{
//                        _movieListState.update{
//                            it.copy(isLoading=result.isLoading)
//                        }
//                    }
//                }
//            }
//            _isRefreshing.emit(false)
//        }
//    }