package com.prasadvennam.domain.usecase.profile

import com.prasadvennam.domain.repository.auth.ProfileRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(
        sessionId: String
    ) = profileRepository.logout(sessionId = sessionId)
}