package com.karakoca.moviekmm.domain.model

import kotlinx.serialization.SerialName

data class Movie(
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val imageUrl: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)
