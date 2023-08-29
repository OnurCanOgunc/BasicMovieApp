package com.decode.basicmovieapp.data.datasourceImpl

import com.decode.basicmovieapp.data.api.MovieService
import com.decode.basicmovieapp.data.datasource.MovieRemoteDataSource
import com.decode.basicmovieapp.data.model.Movie
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val movieService: MovieService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<Movie> =
        movieService.getPopularMovies(apiKey)

}