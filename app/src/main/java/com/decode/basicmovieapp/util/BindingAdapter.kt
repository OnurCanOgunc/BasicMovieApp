package com.decode.basicmovieapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("app:load")
fun load(imageView: ImageView, posterPath: String?) {
    val posterURL = "https://image.tmdb.org/t/p/w500/$posterPath"

    Glide.with(imageView).load(posterURL).centerCrop().into(imageView)
}