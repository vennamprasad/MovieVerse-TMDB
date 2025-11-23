package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.login.LoginScreen
import kotlinx.serialization.Serializable

@Serializable
object LoginRoute : AppDestination

fun NavGraphBuilder.loginRoute(navController: NavHostController) {
    composable<LoginRoute> {
        LoginScreen(
            navigateToHome = {
                val canGoBack = navController.previousBackStackEntry != null
                if (canGoBack) {
                    navController.popBackStack()
                } else {
                    navController.navigate(HomeRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                }
            }
        )
    }
}