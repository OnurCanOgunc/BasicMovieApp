package com.decode.basicmovieapp.data

import com.decode.basicmovieapp.data.datasource.MovieCacheDataSource
import com.decode.basicmovieapp.data.datasource.MovieLocalDataSource
import com.decode.basicmovieapp.data.datasource.MovieRemoteDataSource
import com.decode.basicmovieapp.data.model.Result
import com.decode.basicmovieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Result> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Result> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesFromDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Result> {
        val movieList = mutableListOf<Result>()

        try {
            val response = movieRemoteDataSource.getMovies()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let { movieList.addAll(body.results) }
            }

        } catch (_: Exception) {

        }
        return movieList
    }

    private suspend fun getMoviesFromRoom(): List<Result> {
        val movieList = mutableListOf<Result>()

        try {
            movieList.addAll(movieLocalDataSource.getMoviesFromDB())
        } catch (_: Exception) {

        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList.addAll(getMoviesFromAPI())
            movieLocalDataSource.saveMoviesFromDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Result> {
        val movieList = mutableListOf<Result>()

        try {
            movieList.addAll(movieCacheDataSource.getMovies())
        } catch (_: Exception) {

        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList.addAll(getMoviesFromRoom())
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}