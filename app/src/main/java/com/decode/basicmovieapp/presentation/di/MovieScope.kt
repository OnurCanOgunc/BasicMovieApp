package com.decode.basicmovieapp.presentation.di

import javax.inject.Scope

//@Retention
//Retention, annotation kapsamını belirtir. Kotlin'de üç tür retention vardir.

//RetentionPolicy.RUNTIME: RUNTIME retention ilkesi kullanılarak eklenen annotation, çalışma zamanı boyunca korunur
// ve çalışma zamanı boyunca programımızdan erişilebilir

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MovieScope {
}