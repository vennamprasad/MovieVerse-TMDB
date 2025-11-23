package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.my_collections.MyCollectionsScreen
import kotlinx.serialization.Serializable

@Serializable
object MyCollectionsRoute : AppDestination

fun NavGraphBuilder.myCollections(navController: NavController) {
    composable<MyCollectionsRoute> {
        MyCollectionsScreen(
            onNavigateBack = navController::navigateUp,
            navigateToCollectionDetails = { collectionId, collectionName ->
                navController.navigate(
                    CollectionDetailsRoute(
                        collectionId = collectionId,
                        collectionName = collectionName
                    )
                )
            },
            navigateToCreateCollectionDialog = {
                navController.navigate(CreateCollectionDialogRoute)
            },
            navigateToExplore = { navController.navigate(ExploreRoute) },
            currentBackStackEntry = navController.currentBackStackEntry
        )
    }
}