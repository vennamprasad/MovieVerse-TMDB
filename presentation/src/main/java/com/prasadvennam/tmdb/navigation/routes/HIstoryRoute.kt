package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.history.HistoryScreen
import kotlinx.serialization.Serializable

@Serializable
object HistoryRoute : AppDestination

fun NavGraphBuilder.historyRoute(navController: NavHostController) {
    composable<HistoryRoute> {
        HistoryScreen(
            navigateBack = { navController.popBackStack() },
            navigateToMovieDetails = { movieId -> navController.navigate(MovieDetailsRoute(movieId)) },
            navigateToSeriesDetails = { navController.navigate(SeriesDetailsRoute(it)) },
            navigateToExploreScreen = {navController.navigate(ExploreRoute)}
        )
    }
}