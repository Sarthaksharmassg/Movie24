package com.example.movies24.movieList.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private fun getInstance(): Retrofit {
//        val okHttpClient = OkHttpClient.Builder()
//            .connectTimeout(30, TimeUnit.SECONDS)  // Increase this value if needed
//            .readTimeout(30, TimeUnit.SECONDS)     // Increase this value if needed
//            .writeTimeout(30, TimeUnit.SECONDS)    // Increase this value if needed
//            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okHttpClient)
            .build()
    }
    val movieApi: MovieApi= getInstance().create(MovieApi::class.java)
}