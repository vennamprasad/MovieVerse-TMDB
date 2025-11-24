package com.prasadvennam.tmdb.screen.home.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prasadvennam.tmdb.designSystem.theme.Theme
import com.prasadvennam.tmdb.design_system.R
import com.prasadvennam.tmdb.screen.home.HomeFeaturedCollections

@Composable
fun FeaturedCollectionsSection(
    collections: List<HomeFeaturedCollections>,
    onCollectionClick: (genreId: Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.featured_collections),
            style = Theme.textStyle.title.small,
            color = Theme.colors.shade.primary,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        FeaturedCollections(
            collections = collections,
            onCollectionClick = onCollectionClick
        )
    }

}

@Composable
private fun FeaturedCollections(
    onCollectionClick: (genreId: Int) -> Unit,
    collections: List<HomeFeaturedCollections>
) {
    FlowRow(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        maxItemsInEachRow = 3
    ) {
        collections.forEach { item ->
            CollectionItem(
                modifier = Modifier.width(280.dp),
                titleRes = item.title,
                gradient = item.gradient,
                onClick = { onCollectionClick(item.genreId) }
            )
        }
    }
}

