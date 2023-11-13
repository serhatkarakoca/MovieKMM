package com.karakoca.moviekmm.domain.usecase

import com.karakoca.moviekmm.domain.model.Movie
import com.karakoca.moviekmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPopularMoviesUseCase: KoinComponent {
    private val repository: MovieRepository by inject()

    suspend operator fun invoke(page: Int): List<Movie> {
        return repository.getMovies(page)
    }
}