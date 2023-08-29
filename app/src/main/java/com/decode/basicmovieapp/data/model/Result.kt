package com.decode.basicmovieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.decode.basicmovieapp.utils.Constants.MEALS_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = MEALS_TABLE)
data class Result(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
)