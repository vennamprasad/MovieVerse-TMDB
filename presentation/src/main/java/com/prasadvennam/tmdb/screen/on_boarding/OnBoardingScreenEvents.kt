package com.prasadvennam.tmdb.screen.on_boarding

sealed class OnBoardingScreenEvents {
    data object NavigateToLoginScreen: OnBoardingScreenEvents()
}