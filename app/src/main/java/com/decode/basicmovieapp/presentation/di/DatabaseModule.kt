package com.decode.basicmovieapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.decode.basicmovieapp.data.db.MovieDatabase
import com.decode.basicmovieapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MovieDatabase::class.java, Constants.MOVIE_DATABASE).build()


    @Singleton
    @Provides
    fun providesMovieService(database: MovieDatabase) = database.movieDao()
}