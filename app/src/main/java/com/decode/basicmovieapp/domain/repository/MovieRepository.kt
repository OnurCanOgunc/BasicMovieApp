package com.decode.basicmovieapp.domain.repository

import com.decode.basicmovieapp.data.model.Result

interface MovieRepository {

    suspend fun getMovies(): List<Result>?
    suspend fun updateMovies(): List<Result>?
}