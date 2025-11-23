package com.prasadvennam.tmdb.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.prasadvennam.tmdb.designSystem.component.indicator.MovieCircularProgressBar
import com.prasadvennam.tmdb.designSystem.theme.Theme

@Composable
fun ScreenStateHandler(
    isLoading: Boolean,
    errorMessage: Int?,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(Theme.colors.background.screen)) {

        when {
            isLoading -> {
                MovieCircularProgressBar(
                    modifier = Modifier.align(Alignment.Center),
                    gradientColors = listOf(
                        Theme.colors.brand.primary,
                        Theme.colors.brand.tertiary
                    )
                )
            }

            errorMessage != null -> {
                ErrorContent(
                    errorMessage = errorMessage,
                    onRetry = onRefresh,
                )
            }

            else -> {
                content.invoke()
            }
        }
    }
}