package com.karakoca.moviekmm.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.karakoca.moviekmm.android.common.Destinations
import com.karakoca.moviekmm.android.common.DetailScreen
import com.karakoca.moviekmm.android.common.HomeScreen
import com.karakoca.moviekmm.android.common.MovieAppBar
import com.karakoca.moviekmm.android.common.destinations
import com.karakoca.moviekmm.android.detail.DetailScreen
import com.karakoca.moviekmm.android.detail.MovieDetailViewModel
import com.karakoca.moviekmm.android.home.HomeScreen
import com.karakoca.moviekmm.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainNavController() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination =
        destinations.find { it.routeWithArgs == currentBackStack?.destination?.route } ?: HomeScreen

    Scaffold(scaffoldState = scaffoldState, topBar = {
        MovieAppBar(
            canNavigateBack = navController.previousBackStackEntry != null,
            currentScreen = currentDestination
        ) {
            navController.navigateUp()
        }
    }) { paddingValues ->

        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = HomeScreen.route
        ) {

            composable(HomeScreen.route) {
                val viewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    uiState = viewModel.uiState,
                    loadNextMovies = { viewModel.loadMovies(it) },
                    navigateToDetail = { navController.navigate(DetailScreen.route + "/${it.id}") }
                )
            }

            composable(DetailScreen.routeWithArgs, arguments = DetailScreen.arguments) {
                val movieId = it.arguments?.getInt("movie_id") ?: 0
                val viewModel: MovieDetailViewModel = koinViewModel(
                    parameters = { parametersOf(movieId.toInt()) }
                )
                DetailScreen(uiState = viewModel.uiState)
            }
        }
    }
}