package com.decode.basicmovieapp

import android.app.Application
import com.decode.basicmovieapp.presentation.di.AppComponent
import com.decode.basicmovieapp.presentation.di.AppModule
import com.decode.basicmovieapp.presentation.di.DaggerAppComponent
import com.decode.basicmovieapp.presentation.di.Injector
import com.decode.basicmovieapp.presentation.di.MovieSubComponent
import com.decode.basicmovieapp.presentation.di.NetworkModule
import com.decode.basicmovieapp.presentation.di.RemoteDataModule

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule("https://api.themoviedb.org/3/"))
            .remoteDataModule(RemoteDataModule("5efec856d7f9d50d09e34a7df46068e3"))
            .build()
    }


    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}