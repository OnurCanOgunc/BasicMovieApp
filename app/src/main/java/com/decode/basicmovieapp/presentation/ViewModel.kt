package com.decode.basicmovieapp.presentation

import androidx.lifecycle.ViewModel
import com.decode.basicmovieapp.data.model.Result
import com.decode.basicmovieapp.domain.usecases.GetMoviesUseCase
import com.decode.basicmovieapp.domain.usecases.UpdateMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = flow {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = flow {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}