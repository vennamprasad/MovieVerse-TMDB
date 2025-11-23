package com.prasadvennam.remote.data_source

import com.prasadvennam.data_source.remote.ProfileRemoteDataSource
import com.prasadvennam.remote.dto.profile.response.AccountDto
import com.prasadvennam.remote.dto.profile.response.LogoutResponseDto
import com.prasadvennam.remote.services.ProfileService
import com.prasadvennam.utils.handleApi
import javax.inject.Inject

class ProfileRemoteDataSourceImpl @Inject constructor(
    private val profileService: ProfileService
): ProfileRemoteDataSource {

    override suspend fun getUserInfo(
        accountId: String,
        sessionId: String
    ): AccountDto = handleApi {
        profileService.getUserInfo(accountId,sessionId)
    }

    override suspend fun logout(sessionId: String): LogoutResponseDto  = handleApi {
        profileService.logout(sessionId)
    }
}