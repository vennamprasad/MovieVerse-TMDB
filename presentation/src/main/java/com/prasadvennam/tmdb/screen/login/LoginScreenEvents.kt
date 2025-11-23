package com.prasadvennam.tmdb.screen.login

import com.prasadvennam.tmdb.utlis.StringValue

sealed class LoginScreenEvents {
    data class ShowError(val message: StringValue): LoginScreenEvents()
    data object NavigateTo: LoginScreenEvents()
}