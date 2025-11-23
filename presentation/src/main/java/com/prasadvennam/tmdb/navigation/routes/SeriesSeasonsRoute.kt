package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.details.series_details.series_seasons.SeriesSeasonsScreen
import kotlinx.serialization.Serializable

@Serializable
data class SeriesSeasonsRoute(val seriesId: Int) : AppDestination

fun NavGraphBuilder.seriesSeasonsRoute(navController: NavHostController) {
    composable<SeriesSeasonsRoute>{
        SeriesSeasonsScreen(
            navigateBack = { navController.navigateUp() }
        )
    }
}