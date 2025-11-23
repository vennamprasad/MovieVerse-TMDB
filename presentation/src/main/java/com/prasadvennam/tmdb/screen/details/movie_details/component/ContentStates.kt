package com.prasadvennam.tmdb.screen.details.movie_details.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.prasadvennam.tmdb.designSystem.component.indicator.MovieCircularProgressBar
import com.prasadvennam.tmdb.designSystem.theme.Theme

@Composable
fun LoadingContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        MovieCircularProgressBar(
            gradientColors = listOf(
                Theme.colors.brand.primary,
                Theme.colors.brand.tertiary
            )
        )
    }
}