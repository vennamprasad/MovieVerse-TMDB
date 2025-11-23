package com.prasadvennam.tmdb.designSystem.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.prasadvennam.tmdb.designSystem.component.preview.MovieVersePreviews
import com.prasadvennam.tmdb.designSystem.theme.MovieVerseTheme
import com.prasadvennam.tmdb.designSystem.theme.Theme
import com.prasadvennam.tmdb.design_system.R

@Composable
fun MovieExtendedFloatingButton(
    onClick: () -> Unit,
    icon: Painter,
    iconColor: Color,
    buttonText: String,
    backgroundColor: Color,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier.wrapContentHeight(),
        onClick = onClick,
        shape = RoundedCornerShape(size = Theme.radius.large),
        contentPadding = contentPadding,
        colors = buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.Unspecified
        )
    ) {
        Text(
            modifier = Modifier.padding(end = 8.dp),
            textAlign = TextAlign.Center,
            text = buttonText,
            style = Theme.textStyle.body.medium.medium,
            color = Theme.colors.button.onPrimary
        )
        Icon(
            modifier = Modifier.size(size = 20.dp),
            painter = icon,
            tint = iconColor,
            contentDescription = buttonText
        )
    }
}

@MovieVersePreviews
@Composable
fun MovieExtendedFloatingButtonPreview() {
    MovieVerseTheme {
        MovieExtendedFloatingButton(
            onClick = {},
            icon = painterResource(R.drawable.outline_plus),
            buttonText = "Get Started",
            backgroundColor = Theme.colors.button.primary,
            contentPadding = PaddingValues(all = 14.dp),
            iconColor = Theme.colors.button.secondary
        )
    }
}