package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.profile.response.AccountDto
import com.prasadvennam.remote.dto.profile.response.LogoutResponseDto

interface ProfileRemoteDataSource {
    suspend fun getUserInfo(accountId:String, sessionId:String): AccountDto
    suspend fun logout(sessionId: String): LogoutResponseDto
}