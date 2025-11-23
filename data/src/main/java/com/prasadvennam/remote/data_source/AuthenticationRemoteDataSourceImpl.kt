package com.prasadvennam.remote.data_source

import com.prasadvennam.data_source.remote.AuthenticationRemoteDataSource
import com.prasadvennam.remote.dto.login.GuestSessionDto
import com.prasadvennam.remote.dto.login.LoginResponseDto
import com.prasadvennam.remote.dto.login.RequestTokenDto
import com.prasadvennam.remote.dto.login.SessionDto
import com.prasadvennam.remote.services.AuthenticationService
import com.prasadvennam.utils.handleApi
import javax.inject.Inject


class AuthenticationRemoteDataSourceImpl @Inject constructor(
    private val authenticationService: AuthenticationService
) : AuthenticationRemoteDataSource {
    override suspend fun createRequestToken(): RequestTokenDto = handleApi {
        authenticationService.createRequestToken()
    }

    override suspend fun validateLoginWithRequestToken(
        username: String, password: String, requestToken: String
    ): LoginResponseDto = handleApi {
        authenticationService.validateLoginWithRequestToken(username, password, requestToken)
    }

    override suspend fun createAuthenticatedUserSession(requestToken: String): SessionDto =
        handleApi {
            authenticationService.createAuthenticatedUserSession(requestToken)
        }

    override suspend fun createGuestUserSession(): GuestSessionDto = handleApi {
        authenticationService.createGuestUserSession()
    }


}