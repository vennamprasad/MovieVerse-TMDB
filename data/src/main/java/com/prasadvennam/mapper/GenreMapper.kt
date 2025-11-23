package com.prasadvennam.mapper

import com.prasadvennam.domain.model.Genre
import com.prasadvennam.local.entity.GenreEntity
import com.prasadvennam.remote.dto.genre.GenreDto

fun GenreDto.toEntity(): GenreEntity =
    GenreEntity(
        id = id,
        name = name,
        timestamp = System.currentTimeMillis()
    )

fun GenreEntity.toDomain(): Genre =
    Genre(
        id = id,
        name = name
    )