package com.example.movies24.core

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movies24.movieList.presentation.MovieListViewModel
import com.example.movies24.movieList.util.Screen
//import com.example.movies24.movieList.vM.MovieViewModel
import com.example.movies24.ui.theme.Movies24Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Test", "onCreate: ")
        enableEdgeToEdge()
        //val movieViewModel= ViewModelProvider(owner = this)[MovieViewModel::class.java]
        setContent {
            Movies24Theme {
                Surface(modifier = Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.background) {
//
                    //val movieListViewModel= hiltViewModel<MovieListViewModel>()    //todo Search HiltViewModel
                    Navign()
//                    val navController= rememberNavController()
//                    ScreenCaller(navController = navController)

                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Test", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Test", "onR: ")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Test", "onP: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Test", "onSt: ")
    }
    override fun onDestroy() {
        Log.d("Test", "onD: ")
        super.onDestroy()
        Log.d("Test", "onD: ")
    }

    override fun onRestart() {
        Log.d("Test", "onRestart: ")
        super.onRestart()
    }
}
