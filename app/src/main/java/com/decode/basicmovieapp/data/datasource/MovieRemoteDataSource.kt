package com.decode.basicmovieapp.data.datasource

import com.decode.basicmovieapp.data.model.Movie
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<Movie>
}