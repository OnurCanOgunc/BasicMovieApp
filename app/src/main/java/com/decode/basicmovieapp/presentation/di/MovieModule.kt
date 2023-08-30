package com.decode.basicmovieapp.presentation.di

import com.decode.basicmovieapp.domain.usecases.GetMoviesUseCase
import com.decode.basicmovieapp.domain.usecases.UpdateMoviesUseCase
import com.decode.basicmovieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}