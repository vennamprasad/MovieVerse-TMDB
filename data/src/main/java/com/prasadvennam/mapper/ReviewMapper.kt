package com.prasadvennam.mapper

import com.prasadvennam.domain.model.Review
import com.prasadvennam.remote.dto.review.ReviewDto
import com.prasadvennam.utils.IMAGES_URL
import kotlinx.datetime.LocalDate

fun ReviewDto.toDomain(): Review {
    return Review(
        id = this.id ?: "",
        author = this.author ?: "",
        username = this.authorDetailsDto?.username ?: "",
        avatarPath = if(this.authorDetailsDto?.avatarPath.isNullOrBlank()) "" else "$IMAGES_URL${authorDetailsDto.avatarPath}" ,
        rating = this.authorDetailsDto?.rating?.toFloat()?:0.0f,
        content = this.content ?: "",
        createdAt = if (!createdAt.isNullOrBlank()) LocalDate.parse(createdAt.split('T')[0]) else null,
    )
}