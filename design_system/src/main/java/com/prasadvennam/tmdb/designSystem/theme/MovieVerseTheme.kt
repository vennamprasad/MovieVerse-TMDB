package com.prasadvennam.tmdb.designSystem.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.prasadvennam.tmdb.designSystem.color.LocalMovieVerseColors
import com.prasadvennam.tmdb.designSystem.color.LocalLanguage
import com.prasadvennam.tmdb.designSystem.color.darkThemeColor
import com.prasadvennam.tmdb.designSystem.color.lightThemeColor
import com.prasadvennam.tmdb.designSystem.radius.MovieVerseRadius
import com.prasadvennam.tmdb.designSystem.radius.LocalMovieVerseRadius
import com.prasadvennam.tmdb.designSystem.typography.DefaultTextStyle
import com.prasadvennam.tmdb.designSystem.typography.LocalMovieVerseTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieVerseTheme(
    language: String = "en",
    isDark: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDark) darkThemeColor else lightThemeColor

    CompositionLocalProvider(
        LocalLanguage provides language,
        LocalMovieVerseColors provides colorScheme,
        LocalMovieVerseTextStyle provides DefaultTextStyle,
        LocalMovieVerseRadius provides MovieVerseRadius(),
    ) {
        content()
    }
}