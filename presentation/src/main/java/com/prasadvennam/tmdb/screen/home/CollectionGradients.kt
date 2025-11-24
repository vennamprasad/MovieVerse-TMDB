package com.prasadvennam.tmdb.screen.home

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.geometry.Offset

/**
 * Gradient definitions for each featured collection
 * Uses Compose native gradients instead of XML drawables
 */
data class CollectionGradient(
    val colors: List<Color>,
    val angle: Float  // Angle in degrees
)

object CollectionGradients {
    // Horror - Dark, Menacing, Intense
    val horror = CollectionGradient(
        colors = listOf(
            Color(0xFF2A1B2E),  // Deep Purple
            Color(0xFF4A0E0E),  // Dark Red
            Color(0xFF1A0A1A)   // Black
        ),
        angle = 135f
    )

    // Science Fiction - Cool, Futuristic, High-Tech
    val scienceFiction = CollectionGradient(
        colors = listOf(
            Color(0xFF0D1B3D),  // Deep Navy
            Color(0xFF1A4D7A),  // Cyan Blue
            Color(0xFF2D3B6E)   // Purple
        ),
        angle = 45f
    )

    // Drama - Sophisticated, Elegant, Classic
    val drama = CollectionGradient(
        colors = listOf(
            Color(0xFF3D2B1F),  // Brown
            Color(0xFF6B4423),  // Tan
            Color(0xFF8B5A2B)   // Golden Brown
        ),
        angle = 225f
    )

    // Family - Warm, Friendly, Playful
    val family = CollectionGradient(
        colors = listOf(
            Color(0xFFFF6B4A),  // Coral Red
            Color(0xFFFF8C5A),  // Warm Orange
            Color(0xFFFFD700)   // Gold
        ),
        angle = 90f
    )

    // History - Vintage, Classic, Timeless
    val history = CollectionGradient(
        colors = listOf(
            Color(0xFF5D4E37),  // Chocolate Brown
            Color(0xFF8B7355),  // Tan
            Color(0xFFD4A574)   // Beige Gold
        ),
        angle = 315f
    )

    // Comedy - Bright, Energetic, Fun
    val comedy = CollectionGradient(
        colors = listOf(
            Color(0xFFFF6B9D),  // Hot Pink
            Color(0xFFFFA500),  // Orange
            Color(0xFFFFD700)   // Gold
        ),
        angle = 180f
    )
}

/**
 * Extension function to convert angle (degrees) to gradient direction
 * Used for creating linear gradients with proper angle
 */
fun Float.toGradientAngle(): Pair<Float, Float> {
    val radians = Math.toRadians(this.toDouble())
    val x = kotlin.math.cos(radians).toFloat()
    val y = kotlin.math.sin(radians).toFloat()
    return Pair(x, y)
}

/**
 * Create a linear gradient brush from a CollectionGradient
 */
fun CollectionGradient.toBrush(): Brush {
    val (x, y) = angle.toGradientAngle()
    return Brush.linearGradient(
        colors = colors,
        start = Offset(0f, 0f),
        end = Offset(x * 1000f, y * 1000f)
    )
}