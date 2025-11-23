package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.cast_detials.CastDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
data class CastDetailsRoute(val castId: Int) : AppDestination{
    companion object{
        const val CAST_ID = "castId"

    }
}

fun NavGraphBuilder.castDetailsRoute(navController: NavHostController) {
    composable<CastDetailsRoute>{
        CastDetailsScreen(
            navigateBack = { navController.navigateUp() },
            navigateToMovieDetails = { movieId ->
                navController.navigate(MovieDetailsRoute(movieId))
            },
            navigateToCastBestOfMovie = { actorId, actorName ->
                navController.navigate(
                    CastBestOfMovieRoute(actorId, actorName)
                )
            },
            navigateToCastGallery = { actorId, actorName ->
                navController.navigate(
                    CastGalleryRoute(actorId, actorName)
                )
            }
        )
    }
}