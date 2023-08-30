package com.decode.basicmovieapp.data.datasourceImpl

import com.decode.basicmovieapp.data.datasource.MovieLocalDataSource
import com.decode.basicmovieapp.data.db.MovieDao
import com.decode.basicmovieapp.data.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(
    private val movieDao: MovieDao
) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Result> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesFromDB(movies: List<Result>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}