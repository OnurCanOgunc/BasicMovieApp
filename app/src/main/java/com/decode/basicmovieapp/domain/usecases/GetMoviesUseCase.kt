package com.decode.basicmovieapp.domain.usecases

import com.decode.basicmovieapp.data.model.Result
import com.decode.basicmovieapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Result>? = movieRepository.getMovies()
}