package com.prasadvennam.domain.usecase.collection

import com.prasadvennam.domain.repository.auth.UserRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() = userRepository.isLoggedIn()
}