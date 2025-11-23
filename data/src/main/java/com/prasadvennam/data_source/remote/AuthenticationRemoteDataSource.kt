package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.login.GuestSessionDto
import com.prasadvennam.remote.dto.login.LoginResponseDto
import com.prasadvennam.remote.dto.login.RequestTokenDto
import com.prasadvennam.remote.dto.login.SessionDto

interface AuthenticationRemoteDataSource {

    suspend fun createRequestToken(): RequestTokenDto

    suspend fun validateLoginWithRequestToken(
        username: String,
        password: String,
        requestToken: String
    ): LoginResponseDto

    suspend fun createAuthenticatedUserSession(
        requestToken: String
    ): SessionDto

    suspend fun createGuestUserSession(): GuestSessionDto
    
}