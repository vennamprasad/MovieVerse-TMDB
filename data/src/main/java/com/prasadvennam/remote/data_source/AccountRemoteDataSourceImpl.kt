package com.prasadvennam.remote.data_source

import com.prasadvennam.data_source.remote.AccountRemoteDataSource
import com.prasadvennam.remote.dto.profile.response.AccountDto
import com.prasadvennam.remote.services.AuthenticationService
import com.prasadvennam.utils.handleApi
import javax.inject.Inject

class AccountRemoteDataSourceImpl @Inject constructor(
    private val authenticationService: AuthenticationService
) : AccountRemoteDataSource {
    override suspend fun getUserId(sessionId: String): AccountDto = handleApi {
        authenticationService.getUserId(sessionId)
    }
}