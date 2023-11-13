package com.karakoca.moviekmm.di

import com.karakoca.moviekmm.data.remote.MovieService
import com.karakoca.moviekmm.data.remote.RemoteDataSource
import com.karakoca.moviekmm.data.repository.MoviesRepositoryImpl
import com.karakoca.moviekmm.domain.repository.MovieRepository
import com.karakoca.moviekmm.domain.usecase.GetMovieDetailsUseCase
import com.karakoca.moviekmm.domain.usecase.GetPopularMoviesUseCase
import com.karakoca.moviekmm.util.provideDispatcher
import org.koin.dsl.module


private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MoviesRepositoryImpl(get()) }
    factory { GetMovieDetailsUseCase() }
    factory { GetPopularMoviesUseCase() }
}

private val sharedModules = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModules