package com.example.movies24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies24.movieList.presentation.MovieListViewModel
import com.example.movies24.movieList.util.RatingBar
//import com.example.movies24.movieList.vM.MovieViewModel
import com.example.movies24.ui.theme.Movies24Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //val movieViewModel= ViewModelProvider(owner = this)[MovieViewModel::class.java]
        setContent {
            Movies24Theme {
                Surface(modifier = Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.background) {
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    //RatingBar()
                    val movieListViewModel= hiltViewModel<MovieListViewModel>()    //todo Search HiltViewModel

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Movies24Theme {
        Greeting("Android")
    }
}