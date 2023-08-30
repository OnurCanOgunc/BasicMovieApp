package com.decode.basicmovieapp.presentation.di

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}