package com.example.movies24.core

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Animation
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.MovieFilter
import androidx.compose.material.icons.rounded.Upcoming
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies24.movieList.presentation.MovieListUIEvent
import com.example.movies24.movieList.presentation.MovieListViewModel
import com.example.movies24.movieList.presentation.Top_RatedMoviesScreen
import com.example.movies24.movieList.presentation.UpcomingMoviesScreen
import com.example.movies24.movieList.util.Screen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavController){
    val movieListViewModel= hiltViewModel<MovieListViewModel>()
    val movieListState=movieListViewModel.movieListState.collectAsState().value
    val refreshing by movieListViewModel.isRefrshing.collectAsStateWithLifecycle()
    val pullRefreshState = rememberPullRefreshState(refreshing,{movieListViewModel.refreshpull()})

    val bottommNavController= rememberNavController()    //why?? todo to know 0k

    Scaffold(bottomBar = {
        BottomNaviBar(bottomNavController =bottommNavController , onEvent = movieListViewModel::onEvent)
    }, topBar = {
        TopAppBar(title = {
            Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Text(
                text = if(movieListState.isCurrentScreenTop_Rated){
                "Top-Rated Movies"}
                else{
                    "Upcoming Movies"//todo Can put in string resources
                } ,fontSize=27.sp, fontWeight = FontWeight.Bold
            )
           // Icon(imageVector = Icons.Default.Animation, contentDescription ="Top-Rated Icon",modifier=Modifier.padding(end = 16.dp).size(40.dp) )
                AnimatedStar()
            }
        },
            modifier=Modifier.shadow(10.dp),
            colors=TopAppBarDefaults.smallTopAppBarColors(   //Why crossed
               MaterialTheme.colorScheme.inverseOnSurface
            )
        )
    }) {
        Box(modifier= Modifier
            .fillMaxSize()
            .padding(it)){
           NavHost(navController =bottommNavController,
               startDestination =Screen.Top_RatedMovieList.rout){
               composable(Screen.Top_RatedMovieList.rout){
                    Top_RatedMoviesScreen(
                        navController = navController,
                        movieListState = movieListState, onEvent = movieListViewModel::onEvent)
               }
               composable(Screen.UpcomingMoviesList.rout){
                   UpcomingMoviesScreen(
                       navController = navController,
                       movieListState = movieListState, onEvent = movieListViewModel::onEvent)
               }
               }
           }
        }
    }
@Composable
fun BottomNaviBar(
    bottomNavController: NavHostController,
    onEvent:(MovieListUIEvent)->Unit
){
    val items= listOf(
    BottomItem(title="Top-Rated",icon= Icons.Rounded.MovieFilter), BottomItem(title="Upcoming",icon= Icons.Rounded.Upcoming)
    )
    val selected= rememberSaveable() {    //if rotat screen, can also use remember burt will be reininitialised to 0 on screen roatation
        mutableIntStateOf(0)
    }
    NavigationBar {
        Row(modifier=Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)){
            items.forEachIndexed { index, bottomItem ->
                NavigationBarItem(
                    selected =selected.intValue==index,
                    onClick = {
                        selected.intValue=index
                        when(selected.intValue){
                            0->{
                                onEvent(MovieListUIEvent.Navigate)
                                bottomNavController.popBackStack()
                                bottomNavController.navigate(Screen.Top_RatedMovieList.rout)
                            }
                            1->{
                                onEvent(MovieListUIEvent.Navigate)
                                bottomNavController.popBackStack()
                                bottomNavController.navigate(Screen.UpcomingMoviesList.rout)
                            }
                        }
                              },
                    icon = { 
                        Icon(imageVector = bottomItem.icon, contentDescription =bottomItem.title, tint=MaterialTheme.colorScheme.onBackground )
                    },
                    label={
                        Text(text=bottomItem.title)
                    })
            }
        }
    }
}

data class BottomItem(
    val title: String,
    val icon:ImageVector
)
@Composable
fun AnimatedStar() {
    var isLiked by remember { mutableStateOf(false) }

    // Define the animation values
    val transition = updateTransition(targetState = isLiked, label = "LikeButtonTransition")

    // Define the start and end values for the animation
    val rotation by transition.animateFloat(
        label = "StarRotation",
        transitionSpec = {
            tween(durationMillis = 500, easing = FastOutSlowInEasing)
        }
    ) { liked ->
        if (liked) 360f else 0f
    }

    // Animate the color of the icon
    val iconColor by transition.animateColor(
        label = "StarColor",
        transitionSpec = {
            tween(durationMillis = 500, easing = FastOutSlowInEasing)
        }
    ) { liked ->
        if (liked) Color.Red else Color.Gray
    }

    // Animate the size of the icon
    val iconSize by transition.animateDp(
        label = "StarSize",
        transitionSpec = {
            tween(durationMillis = 500, easing = FastOutSlowInEasing)
        }
    ) { liked ->
        if (liked) 38.dp else 32.dp
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                isLiked = !isLiked
            }
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier
                .size(iconSize)
                .padding(4.dp)
                .rotate(rotation)
        )
    }
}