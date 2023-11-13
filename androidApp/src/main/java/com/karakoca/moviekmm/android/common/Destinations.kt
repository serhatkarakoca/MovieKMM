package com.karakoca.moviekmm.android.common

import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.karakoca.moviekmm.android.R

interface Destinations {
    val title: Int
    val route: String
    val routeWithArgs: String
}

object HomeScreen : Destinations {
    override val title: Int = R.string.movies
    override val route: String = "home"
    override val routeWithArgs: String = route
}

object DetailScreen : Destinations {
    override val title: Int = R.string.movie_details
    override val route: String = "details"
    override val routeWithArgs: String = "$route/{movie_id}"
    val arguments = listOf(navArgument("movie_id") {
        type = NavType.IntType
    })
}

val destinations = listOf(HomeScreen, DetailScreen)