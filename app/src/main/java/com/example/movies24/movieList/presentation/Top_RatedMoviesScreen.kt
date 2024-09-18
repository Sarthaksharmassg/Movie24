package com.example.movies24.movieList.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies24.movieList.presentation.component.MovieItem
import com.example.movies24.movieList.util.Category

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Top_RatedMoviesScreen(
    movieListState: MovieListState,
    navController: NavController,
    onEvent:(MovieListUIEvent)->Unit

){
    if(movieListState.top_RatedMovieList.isEmpty()){
       Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
           CircularProgressIndicator()
       }
    }
    else{
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            modifier=Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
        ) {
            items(movieListState.top_RatedMovieList.size){index->
                MovieItem(movie = movieListState.top_RatedMovieList[index], navHostController =navController)
                Spacer(modifier=Modifier.height(16.dp))
                if((index>=movieListState.top_RatedMovieList.size-1)&& !movieListState.isLoading){
                    onEvent(MovieListUIEvent.Paginate(Category.TOP_RATED))
                }
            }
        }
        //PullRefreshIndicator(refreshing = isRefrshing, state = )
        //TODO pullre freshIndicator()
        //todo
    }
}