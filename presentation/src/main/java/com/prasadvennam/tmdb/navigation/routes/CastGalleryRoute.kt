package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.actor_gallery.ActorGalleryScreen
import kotlinx.serialization.Serializable

@Serializable
data class CastGalleryRoute(val castId: Int, val castName: String) : AppDestination{
    companion object {
        const val CAST_ID = "castId"
        const val CAST_NAME = "castName"
    }
}


fun NavGraphBuilder.castGalleryRoute(navController: NavHostController) {
    composable<CastGalleryRoute>{
        ActorGalleryScreen(
            navigateBack = { navController.navigateUp() },
        )
    }
}