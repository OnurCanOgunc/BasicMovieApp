package com.decode.basicmovieapp.data.datasource

import com.decode.basicmovieapp.data.model.Result

interface MovieCacheDataSource {

    suspend fun getMovies(): List<Result>
    suspend fun saveMoviesToCache(movies: List<Result>)
}