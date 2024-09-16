package com.example.movies24.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navign(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") { SplashScreen(navController = navController) }
        composable("main_screen") {
            val navuController= rememberNavController()
            ScreenCaller(navController = navuController)
        }
    }
}