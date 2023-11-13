package com.karakoca.moviekmm.android.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karakoca.moviekmm.domain.model.Movie
import com.karakoca.moviekmm.domain.model.MovieDetails
import com.karakoca.moviekmm.domain.usecase.GetMovieDetailsUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    val getMovieUseCase: GetMovieDetailsUseCase,
    val movieId: Int
) : ViewModel() {

    var uiState by mutableStateOf(DetailScreenState())

    init {
        loadMovie(movieId)
    }

    private fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            uiState = try {
                val movie = getMovieUseCase(id = movieId)
                uiState.copy(loading = false, movie = movie)
            } catch (error: Throwable) {
                uiState.copy(
                    loading = false,
                    errorMessage = "Could not load the movie"
                )
            }
        }
    }
}

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: MovieDetails? = null,
    var errorMessage: String? = null
)
