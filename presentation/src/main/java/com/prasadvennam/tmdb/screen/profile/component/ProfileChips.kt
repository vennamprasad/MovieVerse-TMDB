package com.prasadvennam.tmdb.screen.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prasadvennam.tmdb.designSystem.theme.MovieVerseTheme
import com.prasadvennam.tmdb.designSystem.theme.Theme
import com.prasadvennam.tmdb.screen.explore.component.PillLabel
import com.prasadvennam.tmdb.presentation.R


data class ProfileChipItem(
    val labelResId: Int,
    val iconResId: Int,
    val onClick: () -> Unit
)

@Composable
internal fun ProfileChips(
    modifier: Modifier = Modifier,
    items: List<ProfileChipItem>,
) {

    Box(
        modifier = modifier,
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(items) { item ->
                PillLabel(
                    text = stringResource(item.labelResId),
                    isActive = false,
                    onClick = { item.onClick() },
                    prefixIcon = {
                        Icon(
                            painter = painterResource(item.iconResId),
                            tint = Theme.colors.brand.primary,
                            contentDescription = "chip icon",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                )
            }
        }
    }

}

@Preview(device = "id:Nexus One")
@Composable
private fun ProfileChipsPreview() {

    MovieVerseTheme {
        ProfileChips(
            modifier = Modifier.padding(top = 12.dp, bottom = 24.dp),

            listOf(
                ProfileChipItem(
                    R.string.history,
                    R.drawable.due_tone_history,
                    {}),
                ProfileChipItem(
                    R.string.my_collections,
                    R.drawable.due_tone_video_library,
                    {}),
                ProfileChipItem(
                    R.string.my_ratings,
                    R.drawable.due_tone_star,
                    {}
                )
            )
        )
    }

}