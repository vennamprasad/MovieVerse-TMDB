package com.prasadvennam.tmdb.designSystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.prasadvennam.tmdb.designSystem.color.MovieVerseColor
import com.prasadvennam.tmdb.designSystem.color.LocalMovieVerseColors
import com.prasadvennam.tmdb.designSystem.radius.MovieVerseRadius
import com.prasadvennam.tmdb.designSystem.radius.LocalMovieVerseRadius
import com.prasadvennam.tmdb.designSystem.typography.MovieVerseTextStyle
import com.prasadvennam.tmdb.designSystem.typography.LocalMovieVerseTextStyle

object Theme {
    val colors: MovieVerseColor
        @Composable
        @ReadOnlyComposable
        get() = LocalMovieVerseColors.current

    val textStyle: MovieVerseTextStyle
        @Composable
        @ReadOnlyComposable
        get() = LocalMovieVerseTextStyle.current

    val radius: MovieVerseRadius
        @Composable
        @ReadOnlyComposable
        get() = LocalMovieVerseRadius.current
}