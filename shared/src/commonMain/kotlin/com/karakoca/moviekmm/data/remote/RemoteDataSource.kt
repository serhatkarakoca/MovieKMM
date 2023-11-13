package com.karakoca.moviekmm.data.remote

import com.karakoca.moviekmm.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(private val api: MovieService, private val dispatcher: Dispatcher) {
    suspend fun getMovies(page: Int) = withContext(dispatcher.io){
        api.getMovies(page = page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io){
        api.getMovie(movieId = movieId)
    }
}
