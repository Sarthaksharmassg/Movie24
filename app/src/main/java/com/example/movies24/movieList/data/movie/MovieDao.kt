package com.example.movies24.movieList.data.movie

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertMovieList(movieList:List<MovieEntity>)

    @Query("Select * from MovieEntity where id= :id")
    suspend fun getMovieById(id:Int):MovieEntity

    @Query("Select * from MovieEntity where category=:category")
    suspend fun getMovieListByCategory(category:String):List<MovieEntity>

    @Query("Delete from MovieEntity")
    suspend fun dataGoesPoof()

}