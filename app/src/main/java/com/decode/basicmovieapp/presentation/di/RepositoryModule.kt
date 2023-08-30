package com.decode.basicmovieapp.presentation.di

import com.decode.basicmovieapp.data.MovieRepositoryImpl
import com.decode.basicmovieapp.data.datasource.MovieCacheDataSource
import com.decode.basicmovieapp.data.datasource.MovieLocalDataSource
import com.decode.basicmovieapp.data.datasource.MovieRemoteDataSource
import com.decode.basicmovieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)
    }
}