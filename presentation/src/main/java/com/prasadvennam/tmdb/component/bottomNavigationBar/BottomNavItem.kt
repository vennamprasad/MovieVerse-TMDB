package com.prasadvennam.tmdb.component.bottomNavigationBar

import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.navigation.routes.ExploreRoute
import com.prasadvennam.tmdb.navigation.routes.MatchRoute
import com.prasadvennam.tmdb.navigation.routes.ProfileRoute
import com.prasadvennam.tmdb.navigation.routes.HomeRoute
import com.prasadvennam.tmdb.presentation.R

sealed class BottomNavItem(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val label: Int,
    val destination: AppDestination
) {
    data object Home : BottomNavItem(
        selectedIcon = R.drawable.due_tone_home,
        unselectedIcon = R.drawable.outline_home,
        label = R.string.home ,
        destination = HomeRoute
    )

    data object Explore : BottomNavItem(
        selectedIcon = R.drawable.due_tone_search,
        unselectedIcon = R.drawable.outline_search,
        label = R.string.explore ,
        destination = ExploreRoute
    )

    data object Match : BottomNavItem(
        selectedIcon = R.drawable.due_tone_magic_stick,
        unselectedIcon = R.drawable.outline_magic_stick,
        label = R.string.match,
        destination = MatchRoute
    )

    data object Me : BottomNavItem(
        selectedIcon = R.drawable.due_tone_user_square,
        unselectedIcon = R.drawable.outline_user_square,
        label = R.string.me,
        destination =  ProfileRoute,

    )

    companion object {
        val destinations = mapOf(
            Home.destination to Home,
            Explore.destination  to Explore,
            Match.destination to Match,
            Me.destination to Me
        )
    }

}