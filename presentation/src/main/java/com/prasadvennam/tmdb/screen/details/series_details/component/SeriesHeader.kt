package com.prasadvennam.tmdb.screen.details.series_details.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.prasadvennam.tmdb.designSystem.component.app_bar.MovieAppBar
import com.prasadvennam.tmdb.designSystem.theme.Theme
import com.prasadvennam.tmdb.design_system.R
import com.prasadvennam.tmdb.screen.details.common.MediaHeader
import com.prasadvennam.tmdb.screen.details.series_details.SeriesDetailsInteractionListener
import com.prasadvennam.tmdb.screen.details.series_details.SeriesDetailsUiState


@Composable
fun SeriesHeader(
    seriesDetails: SeriesDetailsUiState,
    enableBlur: String,
    scrollState: LazyListState,
    interactionListener: SeriesDetailsInteractionListener,
    onNavigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier.background(Theme.colors.background.screen)
    ) {
        MovieAppBar(backButtonClick = onNavigateBack, showBackButton = true)
        seriesDetails.let {
            MediaHeader(
                scrollState = scrollState,
                enableBlur = enableBlur,
                posterUrl = it.posterPath,
                title = it.title,
                genres = it.genre,
                rating = it.rating,
                duration = it.duration,
                releaseDate = it.releaseDate,
                type = stringResource(R.string.series_type),
                onSaveClick = null,
                isSaveEnabled = false,
                onPlayClick = interactionListener::onPlayButtonClicked,
            )
        }
    }

}