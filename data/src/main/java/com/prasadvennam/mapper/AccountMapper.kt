package com.prasadvennam.mapper

import com.prasadvennam.domain.model.UserInfo
import com.prasadvennam.remote.dto.profile.response.AccountDto
import com.prasadvennam.utils.IMAGES_URL

fun AccountDto.toDomain(): UserInfo =
    UserInfo(
        name = name.orEmpty(),
        username = userName.orEmpty(),
        image = avatar?.tmdb?.avatarPath?.let { IMAGES_URL + it }
    )
