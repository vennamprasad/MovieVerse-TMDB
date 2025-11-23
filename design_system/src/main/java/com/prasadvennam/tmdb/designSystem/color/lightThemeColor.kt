package com.prasadvennam.tmdb.designSystem.color

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val lightThemeColor = MovieVerseColor(
    background = Background(
        screen = Color(0xFFFFFFFF),
        card = Color(0xFFF5F5F5),
        bottomSheet = Color(0xFFFFFFFF),
        bottomSheetCard = Color(0xFFF0F0F0),
        bottomSheetContainer = Color(0x12121299)
    ),
    shade = Shade(
        primary = Color(0xFF141414),
        secondary = Color(0xFF404040), // Mid gray
        tertiary = Color(0xFF808080),
        quaternary = Color(0xFFE5E5E5),
        quinary = Color(0xFFF5F5F5)
    ),
    brand = Brand(
        primary = Color(0xFFE50914),
        secondary = Color(0xFFB81D24), // Darker red tone
        tertiary = Color(0xFFFFE5E5) // Soft red surface
    ),
    button = Button(
        primary = Color(0xFFE50914),
        secondary = Color(0xFFFFE5E5),
        disabled = Color(0xFFE0E0E0),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFF141414),
        onDisabled = Color(0xFF808080),
        onTertiary = Color(0xFFE50914)
    ),
    stroke = Stroke(
        primary = Color(0xFFE5E5E5),
        glow = Brush.linearGradient(
            colors = listOf(
                Color(0xFFE50914).copy(alpha = 0.20f),
                Color(0xFFE50914),
                Color(0xFFE50914),
                Color(0xFFE50914).copy(alpha = 0.20f)
            )
        )
    ),
    overlay = Overlay(
        primary = Color(0xFFFFFFFF).copy(alpha = 0.60f),
        secondary = Color(0xFFFFFFFF).copy(alpha = 0.24f),
    ),
    additional = Additional(
        primary = Primary(
            red = Color(0xFFE50914),
            green = Color(0xFF2ECC71),
            yellow = Color(0xFFFFD700)
        ),
        secondary = Secondary(
            red = Color(0xFFFFE5E5),
            green = Color(0xFFE8F7EC),
            yellow = Color(0xFFFFF8DC)
        )
    )
)