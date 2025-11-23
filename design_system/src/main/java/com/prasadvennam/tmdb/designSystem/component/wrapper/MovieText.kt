package com.prasadvennam.tmdb.designSystem.component.wrapper

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.prasadvennam.tmdb.designSystem.component.preview.MovieVersePreviews
import com.prasadvennam.tmdb.designSystem.theme.MovieVerseTheme
import com.prasadvennam.tmdb.designSystem.theme.Theme

@Composable
fun MovieText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Theme.colors.shade.primary,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = Theme.textStyle.label.medium.medium
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        style = style
    )
}

@MovieVersePreviews
@Composable
fun MovieTextPreview() {
    MovieVerseTheme {
        MovieText(
            text = "Sample Movie Title",
            modifier = Modifier.padding(16.dp),
            color = Theme.colors.shade.primary,
            style = Theme.textStyle.label.medium.medium
        )
    }
}