package com.prasadvennam.tmdb.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.prasadvennam.tmdb.navigation.routes.castBestOfMovieRoute
import com.prasadvennam.tmdb.navigation.routes.castDetailsRoute
import com.prasadvennam.tmdb.navigation.routes.castGalleryRoute
import com.prasadvennam.tmdb.navigation.routes.collectionDetailsRoute
import com.prasadvennam.tmdb.navigation.routes.collectionsBottomSheetRoute
import com.prasadvennam.tmdb.navigation.routes.createCollectionDialogRoute
import com.prasadvennam.tmdb.navigation.routes.exploreRoute
import com.prasadvennam.tmdb.navigation.routes.historyRoute
import com.prasadvennam.tmdb.navigation.routes.homeRoute
import com.prasadvennam.tmdb.navigation.routes.loginRoute
import com.prasadvennam.tmdb.navigation.routes.matchRoute
import com.prasadvennam.tmdb.navigation.routes.movieDetailsRoute
import com.prasadvennam.tmdb.navigation.routes.myCollections
import com.prasadvennam.tmdb.navigation.routes.myRatingsRoute
import com.prasadvennam.tmdb.navigation.routes.onBoardingRoute
import com.prasadvennam.tmdb.navigation.routes.profileRoute
import com.prasadvennam.tmdb.navigation.routes.recommendationsRoute
import com.prasadvennam.tmdb.navigation.routes.reviewsRoute
import com.prasadvennam.tmdb.navigation.routes.seeMoreRoute
import com.prasadvennam.tmdb.navigation.routes.seriesDetailsRoute
import com.prasadvennam.tmdb.navigation.routes.seriesRecommendationRoute
import com.prasadvennam.tmdb.navigation.routes.seriesSeasonsRoute
import com.prasadvennam.tmdb.navigation.routes.webViewRoute

val LocalScaffoldPaddingValues =
    staticCompositionLocalOf<PaddingValues> { error("No ScaffoldPadding provided") }

@Composable
fun MovieVerseNavGraph(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: AppDestination,
    scaffoldPaddingValues: PaddingValues,
    onBottomNavVisibilityChange: (Boolean) -> Unit = {}
) {

    CompositionLocalProvider(
        LocalScaffoldPaddingValues provides scaffoldPaddingValues
    ) {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination
        ) {


            exploreRoute(navController)
            loginRoute(navController)
            onBoardingRoute(navController)
            recommendationsRoute(navController)
            reviewsRoute(navController)
            castDetailsRoute(navController)
            castGalleryRoute(navController)
            castBestOfMovieRoute(navController)
            movieDetailsRoute(navController)
            seriesDetailsRoute(navController)
            seriesRecommendationRoute(navController)
            seriesSeasonsRoute(navController)
            collectionsBottomSheetRoute(navController)
            homeRoute(navController)
            seeMoreRoute(navController)
            matchRoute(navController, onBottomNavVisibilityChange)
            profileRoute(navController)
            collectionDetailsRoute(navController)
            myCollections(navController)
            createCollectionDialogRoute(navController)
            historyRoute(navController)
            myRatingsRoute(navController)
            webViewRoute(navController)

        }
    }
}