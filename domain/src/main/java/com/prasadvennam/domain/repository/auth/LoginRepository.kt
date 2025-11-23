package com.prasadvennam.domain.repository.auth

interface LoginRepository {
    suspend fun loginWithUsernameAndPassword(
        username: String,
        password: String
    ): Boolean

    suspend fun loginAsGuest(): Boolean
}