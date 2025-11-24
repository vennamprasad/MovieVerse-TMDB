package com.prasadvennam.tmdb.screen.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prasadvennam.tmdb.designSystem.theme.Theme

/**
 * Page indicator dots showing current page position
 *
 * @param currentPage The current active page
 * @param pageCount Total number of pages
 * @param onPageClick Callback when user clicks a dot to navigate
 * @param modifier Modifier for the container
 */
@Composable
fun PageIndicatorDots(
    currentPage: Int,
    pageCount: Int,
    onPageClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        repeat(pageCount) { index ->
            val isActive = index == currentPage
            val dotSize by animateDpAsState(
                targetValue = if (isActive) 8.dp else 6.dp,
                label = "dotSize"
            )
            val dotColor by animateColorAsState(
                targetValue = if (isActive)
                    Theme.colors.brand.primary
                else
                    Theme.colors.shade.tertiary.copy(alpha = 0.4f),
                label = "dotColor"
            )

            Box(
                modifier = Modifier
                    .size(dotSize)
                    .clip(CircleShape)
                    .background(dotColor)
                    .clickable { onPageClick(index) }
            )
        }
    }
}

/**
 * Linear progress indicator for carousel pages
 * Shows progress as a line that fills from left to right
 *
 * @param currentPage The current active page
 * @param pageCount Total number of pages
 * @param modifier Modifier for the container
 */
@Composable
fun PageProgressIndicator(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier
) {
    val progress = if (pageCount > 0) (currentPage + 1).toFloat() / pageCount else 0f

    Box(
        modifier = modifier
            .background(
                color = Theme.colors.shade.quaternary
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .background(
                    color = Theme.colors.brand.primary
                )
        )
    }
}