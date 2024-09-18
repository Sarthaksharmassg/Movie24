package com.example.movies24.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.movies24.details.presentation.DetailsScreen
import com.example.movies24.movieList.util.Screen
@Composable
fun ScreenCaller(navController: NavHostController){
NavHost(navController=navController, startDestination = Screen.Home.rout){
    composable(Screen.Home.rout){
        HomeScreen(navController)
    }
    composable(
        Screen.Details.rout +"/{movieId}", arguments = listOf(
        navArgument("movieId"){type= NavType.IntType}
    )){
        DetailsScreen()
        //navController.popBackStack()
    }
}
}