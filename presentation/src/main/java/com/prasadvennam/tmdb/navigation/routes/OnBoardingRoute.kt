package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.on_boarding.OnBoardingScreen
import kotlinx.serialization.Serializable

@Serializable
object OnBoardingRoute: AppDestination

fun NavGraphBuilder.onBoardingRoute(navController: NavHostController){
    composable<OnBoardingRoute> {
        OnBoardingScreen(
            navigateToLogin = {
                navController.navigate(LoginRoute) {
                    popUpTo(OnBoardingRoute) { inclusive = true }
                }
            }
        )
    }
}