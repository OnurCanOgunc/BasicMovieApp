package com.decode.basicmovieapp.data.datasourceImpl

import com.decode.basicmovieapp.data.datasource.MovieCacheDataSource
import com.decode.basicmovieapp.data.model.Result

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Result>()

    override suspend fun getMovies(): List<Result> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Result>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}