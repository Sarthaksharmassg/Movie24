//package com.example.movies24.movieList.vM
//import com.example.movies24.movieList.data.remote.respond.MovieResultDetails
//import com.example.movies24.movieList.data.remote.MovieApi
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.movies24.movieList.data.remote.RetrofitInstance
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import retrofit2.Retrofit
//
//class MovieViewModel: ViewModel() {
//    private val _movies= MutableStateFlow<List<MovieResultDetails>>(emptyList())
//    public val movies: StateFlow<List<MovieResultDetails>> = _movies.asStateFlow()   //SearchPT
//  val authToken= "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNzhjMTVjYzFlM2M4NTZkOGM2ZjlmOGFhMmNiZWUzNiIsIm5iZiI6MTcyNDg3NDQyMi45NTA0MTQsInN1YiI6IjY2Y2I4Mjk5YmJhOGI2OWQ0YTEwM2E4OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4fzbAV0A_1RcwzrCAdF6Aw4w8NOQqjKstpvUFz_UE3I"
//    fun fetchMoviesByCategory(category: String){
//        viewModelScope.launch{
//            try {
//                val fetchedMovies = RetrofitInstance.movieApi.getMovieList()
//                _movies.value = fetchedMovies
//                println("Testing....${fetchedMovies}")
//            }
//            catch(e:Exception){
//                println(e)
//            }
//        }
//    }
//}