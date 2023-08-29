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

    override suspend fun getMovies(): List<Result>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Result>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesFromDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Result> {
        lateinit var movieList: List<Result>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            body?.let { movieList = body.results }

        } catch (e: Exception) {

        }
        return movieList
    }

    private suspend fun getMoviesFromRoom(): List<Result> {
        lateinit var movieList: List<Result>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {

        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesFromDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Result>? {
        lateinit var movieList: List<Result>

        try {
            movieList = movieCacheDataSource.getMovies()
        } catch (e: Exception) {

        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromRoom()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}