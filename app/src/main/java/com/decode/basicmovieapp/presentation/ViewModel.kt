package com.decode.basicmovieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.decode.basicmovieapp.domain.usecases.GetMoviesUseCase
import com.decode.basicmovieapp.domain.usecases.UpdateMoviesUseCase

class ViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}