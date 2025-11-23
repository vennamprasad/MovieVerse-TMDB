package com.prasadvennam.tmdb.designSystem.component.wrapper

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.prasadvennam.tmdb.designSystem.component.preview.MovieVersePreviews
import com.prasadvennam.tmdb.design_system.R

@Composable
fun MovieIcon(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
) {
    Icon(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
        tint = tint
    )
}

@MovieVersePreviews
@Composable
private fun Preview() {
    MovieIcon(
        painter = painterResource(R.drawable.movieverse)
    )
}