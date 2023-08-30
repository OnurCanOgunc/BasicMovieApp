package com.decode.basicmovieapp.presentation.di

import com.decode.basicmovieapp.data.api.MovieService
import com.decode.basicmovieapp.data.datasource.MovieRemoteDataSource
import com.decode.basicmovieapp.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(movieService: MovieService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(movieService,apiKey)
    }
}