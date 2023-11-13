package com.karakoca.moviekmm.domain.usecase

import com.karakoca.moviekmm.domain.model.MovieDetails
import com.karakoca.moviekmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMovieDetailsUseCase: KoinComponent {
    private val repository: MovieRepository by inject()

    suspend operator fun invoke(id: Int): MovieDetails {
        return repository.getMovieDetails(id)
    }
}