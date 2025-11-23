package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.profile.response.AccountDto

interface AccountRemoteDataSource {
    suspend fun getUserId(
        sessionId: String
    ): AccountDto
}