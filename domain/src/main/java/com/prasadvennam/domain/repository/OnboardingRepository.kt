package com.prasadvennam.domain.repository

interface OnboardingRepository {
    suspend fun isOnBoardingCompleted(): Boolean
    suspend fun setOnBoardingCompleted()
}