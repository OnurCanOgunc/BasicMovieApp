package com.decode.basicmovieapp.data.datasource

import com.decode.basicmovieapp.data.model.Result

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Result>
    suspend fun saveMoviesFromDB(movies: List<Result>)
    suspend fun clearAll()
}