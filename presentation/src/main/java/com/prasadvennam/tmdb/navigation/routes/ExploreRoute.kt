package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.explore.ExploreScreen
import kotlinx.serialization.Serializable

@Serializable
object ExploreRoute : AppDestination

fun NavGraphBuilder.exploreRoute(navController: NavHostController) {
    composable<ExploreRoute>{
        ExploreScreen(
            navigateToCastDetails = { actorId ->
                navController.navigate(CastDetailsRoute(actorId))
            },
            navigateToMovieDetails = { movieId ->
                navController.navigate(MovieDetailsRoute(movieId))
            },
            navigateToSeriesDetails = { seriesId ->
                navController.navigate(SeriesDetailsRoute(seriesId))
            }
        )
    }
}