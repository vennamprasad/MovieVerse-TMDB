package com.prasadvennam.tmdb.designSystem.color

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val darkThemeColor = MovieVerseColor(
    background = Background(
        screen = Color(0xFF141414),
        card = Color(0xFF1A1A1A),
        bottomSheet = Color(0xFF1A1A1A),
        bottomSheetCard = Color(0xFF222222),
        bottomSheetContainer = Color(0x12121299)
    ),
    shade = Shade(
        primary = Color(0xFFFFFFFF),
        secondary = Color(0xFFB3B3B3),
        tertiary = Color(0xFF808080),
        quaternary = Color(0xFF333333),
        quinary = Color(0xFF222222)
    ),
    brand = Brand(
        primary = Color(0xFFE50914),
        secondary = Color(0xFFB81D24), // Darker red
        tertiary = Color(0xFF330000) // Deep red tint background
    ),
    button = Button(
        primary = Color(0xFFE50914),
        secondary = Color(0xFF330000),
        disabled = Color(0xFF333333),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFFB3B3B3),
        onDisabled = Color(0xFF808080),
        onTertiary = Color(0xFFE50914)
    ),
    stroke = Stroke(
        primary = Color(0xFF333333),
        glow = Brush.linearGradient(
            colors = listOf(
                Color(0xFFE50914).copy(alpha = 0.22f),
                Color(0xFFE50914),
                Color(0xFFE50914),
                Color(0xFFE50914).copy(alpha = 0.22f)
            )
        )
    ),
    overlay = Overlay(
        primary = Color(0xFF141414).copy(alpha = 0.60f),
        secondary = Color(0xFF141414).copy(alpha = 0.24f),
    ),
    additional = Additional(
        primary = Primary(
            red = Color(0xFFE50914),
            green = Color(0xFF00E676),
            yellow = Color(0xFFFFD600)
        ),
        secondary = Secondary(
            red = Color(0xFF2C0000),
            green = Color(0xFF0A2F1F),
            yellow = Color(0xFF2D2A00)
        )
    )
)
