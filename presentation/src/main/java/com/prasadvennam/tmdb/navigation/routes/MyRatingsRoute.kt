package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.navigation.navigateToNewGraph
import com.prasadvennam.tmdb.screen.myratings.MyRatingScreen
import kotlinx.serialization.Serializable

@Serializable
object MyRatingsRoute : AppDestination

fun NavGraphBuilder.myRatingsRoute(navController: NavHostController) {
    composable<MyRatingsRoute> {
        MyRatingScreen(
            navigateBack = {
                navController.navigateUp()
            },
            navigateToMovieDetails = { movieId ->
                navController.navigate(
                    MovieDetailsRoute(movieId)
                )
            },
            navigateToSeriesDetails = { seriesId ->
                navController.navigate(
                    SeriesDetailsRoute(seriesId)
                )
            },
            navigateToExplore = {
                navController.navigateToNewGraph(ExploreRoute)
            }
        )
    }
}