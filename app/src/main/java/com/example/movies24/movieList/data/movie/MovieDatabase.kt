package com.example.movies24.movieList.data.movie

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(      //SearchPT
    entities = [MovieEntity::class],
    version =1
)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao : MovieDao
}