package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.profile.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
object ProfileRoute : AppDestination

fun NavGraphBuilder.profileRoute(navController: NavHostController) {
    composable<ProfileRoute>{
        ProfileScreen(
            navigateToWebSite = { url->
               navController.navigate(WebViewRoute(url))
            },
            navigateToLogin = {
                navController.navigate(LoginRoute)
            },
            navigateToMyRatings = {
                navController.navigate(MyRatingsRoute)

            },
            navigateToMyCollections = {
                navController.navigate(MyCollectionsRoute)
            },
            navigateToMyHistory = {
                navController.navigate(HistoryRoute)

            }
        )
    }
}