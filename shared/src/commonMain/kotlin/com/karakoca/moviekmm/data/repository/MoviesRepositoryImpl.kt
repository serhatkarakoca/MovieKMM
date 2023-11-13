package com.karakoca.moviekmm.data.repository

import com.karakoca.moviekmm.data.remote.KtorApi
import com.karakoca.moviekmm.data.remote.MovieService
import com.karakoca.moviekmm.data.remote.RemoteDataSource
import com.karakoca.moviekmm.data.util.toMovie
import com.karakoca.moviekmm.data.util.toMovieDetails
import com.karakoca.moviekmm.domain.model.Movie
import com.karakoca.moviekmm.domain.model.MovieDetails
import com.karakoca.moviekmm.domain.repository.MovieRepository

internal class MoviesRepositoryImpl(private val remoteDateSource: RemoteDataSource): MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDateSource.getMovies(page).toMovie()
    }

    override suspend fun getMovieDetails(id: Int): MovieDetails {
        return remoteDateSource.getMovie(id).toMovieDetails()
    }
}