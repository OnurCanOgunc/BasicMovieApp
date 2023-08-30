package com.decode.basicmovieapp.presentation.di

import com.decode.basicmovieapp.data.datasource.MovieLocalDataSource
import com.decode.basicmovieapp.data.datasourceImpl.MovieLocalDataSourceImpl
import com.decode.basicmovieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
}