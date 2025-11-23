package com.prasadvennam.mapper

import com.prasadvennam.local.entity.FavouriteGenreEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlin.collections.sortedByDescending

suspend fun Flow<List<FavouriteGenreEntity>>.toSortedGenres(): List<Int> {
    return this
        .first()
        .sortedByDescending { it.count }
        .map { it.genreId }
}
