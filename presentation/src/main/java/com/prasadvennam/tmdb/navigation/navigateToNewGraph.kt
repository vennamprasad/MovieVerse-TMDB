package com.prasadvennam.tmdb.navigation

import androidx.navigation.NavController
import com.prasadvennam.tmdb.component.bottomNavigationBar.BottomNavItem
import com.prasadvennam.tmdb.navigation.routes.HomeRoute

fun NavController.navigateToNewGraph(newGraph: AppDestination) {
    val currentDestination = currentBackStackEntry?.destination?.route

    val isOnBottomNavDestination = BottomNavItem.destinations.keys.any { destination ->
        destination.toString() == currentDestination ||
                destination::class.simpleName == currentDestination
    }

    if (isOnBottomNavDestination) {
        navigate(newGraph) {
            popUpTo(HomeRoute) {
                inclusive = newGraph == HomeRoute
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    } else {
        navigate(newGraph) {
            launchSingleTop = true
            restoreState = true
        }
    }
}