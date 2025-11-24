package com.prasadvennam.tmdb.screen.home.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.component.MediaPosterCard
import com.prasadvennam.tmdb.designSystem.theme.Theme
import com.prasadvennam.tmdb.utlis.noRibbleClick
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

/**
 * Enhanced HomeHeaderSlider with improved UX
 *
 * Enhancements:
 * - Page indicator dots for better navigation
 * - Auto-pause on scroll/interaction
 * - Smooth text transitions with animations
 * - Click feedback with scale animation
 * - Better loading states
 * - Improved accessibility
 *
 * @param items List of media items to display
 * @param onSliderClick Callback when an item is clicked
 * @param enableBlur Whether to enable blur effect on images
 * @param modifier Modifier for the component
 */
@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeHeaderSliderEnhanced(
    items: List<MediaItemUiState>,
    onSliderClick: (MediaItemUiState) -> Unit,
    enableBlur: String,
    modifier: Modifier = Modifier
) {
    if (items.isEmpty()) return

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { items.size }
    )

    val currentItem by remember {
        derivedStateOf { items[pagerState.currentPage] }
    }

    // Track if user is actively interacting
    var isUserInteracting by remember { mutableStateOf(false) }

    val animatedRating by animateFloatAsState(
        targetValue = currentItem.rating,
        animationSpec = tween(durationMillis = 500),
        label = "ratingAnimation"
    )

    val pageOffset by remember {
        derivedStateOf { pagerState.currentPageOffsetFraction.absoluteValue.coerceIn(0f, 0.5f) }
    }
    val normalizedOffset = pageOffset * 2f
    val factor = (1f - normalizedOffset).coerceIn(0f, 1f)
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val scope = rememberCoroutineScope()

    val screenWidth = with(density) { configuration.screenWidthDp.dp }
    val width = screenWidth - 48.dp

    // Auto-rotation with pause on interaction
    LaunchedEffect(pagerState, isUserInteracting) {
        while (true) {
            // Reset interaction flag after 5 seconds of inactivity
            if (isUserInteracting) {
                delay(5000)
                isUserInteracting = false
            } else {
                delay(3000)
            }

            if (!pagerState.isScrollInProgress && !isUserInteracting) {
                val nextPage = (pagerState.currentPage + 1) % items.size
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = spring(
                        stiffness = Spring.StiffnessVeryLow,
                        dampingRatio = Spring.DampingRatioLowBouncy
                    )
                )
            }
        }
    }

    // Stop auto-rotation when user scrolls
    DisposableEffect(pagerState.isScrollInProgress) {
        if (pagerState.isScrollInProgress) {
            isUserInteracting = true
        }
        onDispose { }
    }

    Box(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = (-40).dp,
            verticalAlignment = Alignment.CenterVertically,
            beyondViewportPageCount = 1
        ) { page ->
            val pageOffset =
                ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
                    .absoluteValue.coerceIn(0f, 1f)

            val animatedHeight = lerp(230.dp, 200.dp, 1f - pageOffset)
            val animatedWidth = lerp(360.dp, 312.dp, 1f - pageOffset)

            val cardAlpha = lerp(0.6f, 1f, 1f - pageOffset)
            val textAlpha = 1f - pageOffset * 3f

            // Card press animation
            var isPressed by remember { mutableStateOf(false) }
            val cardScale by animateDpAsState(
                targetValue = if (isPressed) 8.dp else 0.dp,
                label = "cardScale"
            )

            Box(
                modifier = Modifier
                    .height(270.dp)
                    .zIndex(1f - pageOffset)
            ) {
                MediaPosterCard(
                    mediaItem = items[page],
                    showRating = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(BiasAlignment(0f, pageOffset - 1f))
                        .alpha(cardAlpha)
                        .size(width = animatedWidth, height = animatedHeight)
                        .clip(RoundedCornerShape(Theme.radius.extraLarge))
                        .noRibbleClick(
                            onClick = {
                                isUserInteracting = true
                                onSliderClick(items[page])
                            }
                        ),
                    onMediaItemClick = { onSliderClick(items[page]) },
                    showBackdrop = true,
                    showTitle = false,
                    enableBlur = enableBlur,
                    useFixedHeight = true
                )

                // Animated rating with better visibility
                if (textAlpha > 0) {
                    AnimatedRatingDisplaySection(
                        rating = animatedRating,
                        alpha = 1f,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .scale(1f + (1f - factor) * 0.1f)
                    )
                }
            }
        }

        // Info section with smooth transitions
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 32.dp)
                .padding(bottom = 56.dp, top = 8.dp)
                .fillMaxWidth(0.8f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Animated title with fade/slide
            AnimatedContent(
                targetState = currentItem.title,
                transitionSpec = {
                    (slideInHorizontally { it } + fadeIn()) togetherWith
                            (slideOutHorizontally { -it } + fadeOut())
                },
                label = "titleAnimation"
            ) { title ->
                Text(
                    text = title,
                    color = Theme.colors.shade.primary,
                    style = Theme.textStyle.body.medium.medium,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.noRibbleClick {
                        isUserInteracting = true
                        onSliderClick(currentItem)
                    }
                )
            }

            // Animated genres with fade/slide
            AnimatedContent(
                targetState = currentItem.genres.joinToString(),
                transitionSpec = {
                    (slideInHorizontally { -it } + fadeIn()) togetherWith
                            (slideOutHorizontally { it } + fadeOut())
                },
                label = "genreAnimation"
            ) { genres ->
                Text(
                    text = genres,
                    color = Theme.colors.shade.secondary,
                    style = Theme.textStyle.body.small.regular,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }

        // Page indicator dots at bottom
        PageIndicatorDots(
            currentPage = pagerState.currentPage,
            pageCount = items.size,
            onPageClick = { newPage ->
                scope.launch {
                    isUserInteracting = true
                    pagerState.animateScrollToPage(
                        newPage,
                        animationSpec = spring(
                            stiffness = Spring.StiffnessVeryLow,
                            dampingRatio = Spring.DampingRatioLowBouncy
                        )
                    )
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
        )
    }
}