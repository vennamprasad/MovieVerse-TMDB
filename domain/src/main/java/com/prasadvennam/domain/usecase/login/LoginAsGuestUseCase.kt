package com.prasadvennam.domain.usecase.login

import com.prasadvennam.domain.repository.auth.LoginRepository
import javax.inject.Inject

class LoginAsGuestUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke() = loginRepository.loginAsGuest()
}