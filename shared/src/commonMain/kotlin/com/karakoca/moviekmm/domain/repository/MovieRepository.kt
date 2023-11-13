package com.karakoca.moviekmm.domain.repository

import com.karakoca.moviekmm.domain.model.Movie
import com.karakoca.moviekmm.domain.model.MovieDetails

internal interface MovieRepository {

    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovieDetails(id: Int): MovieDetails
}