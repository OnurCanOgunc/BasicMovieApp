package com.decode.basicmovieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.decode.basicmovieapp.domain.usecases.GetMoviesUseCase
import com.decode.basicmovieapp.domain.usecases.UpdateMoviesUseCase

class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.decode.basicmovieapp.presentation.ViewModel(
            getMoviesUseCase,
            updateMoviesUseCase
        ) as T
    }
}