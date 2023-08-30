package com.decode.basicmovieapp.presentation.di

import com.decode.basicmovieapp.data.datasource.MovieCacheDataSource
import com.decode.basicmovieapp.data.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}