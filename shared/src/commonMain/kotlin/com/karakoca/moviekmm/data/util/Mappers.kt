package com.karakoca.moviekmm.data.util

import com.karakoca.moviekmm.data.model.MovieDetailDto
import com.karakoca.moviekmm.data.model.PopularMoviesDto
import com.karakoca.moviekmm.domain.model.Movie
import com.karakoca.moviekmm.domain.model.MovieDetails
import com.karakoca.moviekmm.util.Constants.IMAGE_URL


internal fun PopularMoviesDto.toMovie(): List<Movie> {
    return this.results?.mapNotNull { Movie(
        id = it?.id ?: 0,
        originalLanguage = it?.originalLanguage ?: "",
        originalTitle = it?.originalTitle ?: "",
        imageUrl = IMAGE_URL+it?.posterPath,
        releaseDate = it?.releaseDate ?: "",
        title = it?.title ?: "",
        voteAverage = it?.voteAverage ?: 0.0,
        voteCount = it?.voteCount ?: 0) } ?: emptyList()
    
}

internal fun MovieDetailDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        id = id,
        genres = genres,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        imageUrl = IMAGE_URL+posterPath,
        releaseDate = releaseDate,
        runtime = runtime,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount
    )

}