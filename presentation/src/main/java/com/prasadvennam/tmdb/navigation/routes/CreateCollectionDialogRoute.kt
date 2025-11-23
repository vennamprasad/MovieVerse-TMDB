package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.my_collections.create_collection_dialog.CreateCollectionDialog
import kotlinx.serialization.Serializable

@Serializable
data object CreateCollectionDialogRoute : AppDestination

fun NavGraphBuilder.createCollectionDialogRoute(navController: NavController) {
    dialog<CreateCollectionDialogRoute> {
        CreateCollectionDialog(
            onNavigateBack = { collectionId, collectionName ->
                navController
                    .previousBackStackEntry
                    ?.savedStateHandle
                    ?.apply {
                        set("collection_name", collectionName)
                        set("collection_Id", collectionId)
                    }
                navController.navigateUp()
            },
        )
    }
}