package com.decode.basicmovieapp.data.model


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("results")
    val results: List<Result>
)