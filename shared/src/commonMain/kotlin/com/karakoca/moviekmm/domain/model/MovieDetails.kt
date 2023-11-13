package com.karakoca.moviekmm.domain.model

import com.karakoca.moviekmm.data.model.Genre
import com.karakoca.moviekmm.data.model.ProductionCompany
import com.karakoca.moviekmm.data.model.ProductionCountry
import com.karakoca.moviekmm.data.model.SpokenLanguage
import kotlinx.serialization.SerialName

data class MovieDetails(
    val id: Int?,
    val genres: List<Genre?>?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val imageUrl: String?,
    val releaseDate: String?,
    val runtime: Int?,
    val title: String?,
    val voteAverage: Double?,
    val voteCount: Int?
)
