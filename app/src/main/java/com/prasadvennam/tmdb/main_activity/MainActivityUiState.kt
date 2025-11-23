package com.prasadvennam.tmdb.main_activity

import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.navigation.routes.OnBoardingRoute

data class MainActivityUiState(
    val isLoading: Boolean = true,
    val isDarkTheme: Boolean = false,
    val language: String = "en",
    val startDestination: AppDestination = OnBoardingRoute
)