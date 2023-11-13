package com.karakoca.moviekmm.android.di

import com.karakoca.moviekmm.android.detail.MovieDetailViewModel
import com.karakoca.moviekmm.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> MovieDetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}