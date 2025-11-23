package com.prasadvennam.tmdb

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prasadvennam.tmdb.component.bottomNavigationBar.BottomNavItem.Companion.destinations
import com.prasadvennam.tmdb.component.bottomNavigationBar.NavBar
import com.prasadvennam.tmdb.designSystem.theme.Theme
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.navigation.MovieVerseNavGraph
import com.prasadvennam.tmdb.navigation.navigateToNewGraph
import com.prasadvennam.tmdb.navigation.rememberIsInGraph
import com.prasadvennam.tmdb.navigation.rememberNavGraphIndex

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieVerseRoot(
    startDestination: AppDestination
) {

    val navController = rememberNavController()

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()

    val navGraphIndex by rememberNavGraphIndex(currentNavBackStackEntry, destinations.keys)

    val isNavBarVisible by rememberIsInGraph(currentNavBackStackEntry, destinations.keys)

    var matchBottomNavVisible by rememberSaveable { mutableStateOf(true) }

    val showBottomNav = isNavBarVisible && matchBottomNavVisible

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            if (showBottomNav) NavBar(
                selectedItem = destinations.values.elementAt(navGraphIndex),
                onItemClick = { index, _ ->
                    val targetGraph = destinations.keys.elementAt(index)
                    navController.navigateToNewGraph(targetGraph)
                })
        }
    ) { paddingValues ->
        MovieVerseNavGraph(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background.screen),
            navController = navController,
            startDestination = startDestination,
            scaffoldPaddingValues = paddingValues,
            onBottomNavVisibilityChange = { isVisible ->
                matchBottomNavVisible = isVisible
            }
        )

    }
}
