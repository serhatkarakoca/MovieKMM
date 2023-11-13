package com.karakoca.moviekmm.data.remote

import com.karakoca.moviekmm.data.model.MovieDetailDto
import com.karakoca.moviekmm.data.model.PopularMoviesDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService: KtorApi() {

    suspend fun getMovies(page: Int): PopularMoviesDto = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(movieId: Int): MovieDetailDto = client.get {
        pathUrl("movie/${movieId}")
    }.body()

}