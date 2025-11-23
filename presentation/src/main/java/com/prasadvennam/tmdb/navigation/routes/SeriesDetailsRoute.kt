package com.prasadvennam.tmdb.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.prasadvennam.tmdb.navigation.AppDestination
import com.prasadvennam.tmdb.screen.details.series_details.SeriesDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
data class SeriesDetailsRoute(val seriesId: Int) : AppDestination {
    companion object {
        const val SERIES_ID = "seriesId"
    }
}

fun NavGraphBuilder.seriesDetailsRoute(navController: NavHostController) {
    composable<SeriesDetailsRoute> {
        SeriesDetailsScreen(
            navigateBack = {
                navController.navigateUp()
            },
            navigateToCollectionBottomSheet = { seriesId ->
                navController.navigate(CollectionsBottomSheetRoute(mediaItemId = seriesId))

            },
            navigateToSeriesRecommendation = { seriesId, seriesName ->
                navController.navigate(SeriesRecommendationRoute(seriesId, seriesName))
            },
            navigateToReviews = { seriesId ->
                navController.navigate(ReviewsRoute(seriesId, false))
            },
            navigateToSeriesSeasons = { seriesId ->
                navController.navigate(SeriesSeasonsRoute(seriesId))
            },
            navigateToCastDetails = { castId ->
                navController.navigate(CastDetailsRoute(castId))
            },
            navigateToSeriesDetails = { seriesId ->
                navController.navigate(SeriesDetailsRoute(seriesId))
            },
            navigateToLogin = { navController.navigate(LoginRoute) }
        )
    }
}