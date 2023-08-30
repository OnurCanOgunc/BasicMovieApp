package com.decode.basicmovieapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.decode.basicmovieapp.data.db.MovieDatabase
import com.decode.basicmovieapp.presentation.util.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesRoom(context: Context) =
        Room.databaseBuilder(context, MovieDatabase::class.java, Constants.MOVIE_DATABASE).build()


    @Singleton
    @Provides
    fun providesMovieService(database: MovieDatabase) = database.movieDao()
}