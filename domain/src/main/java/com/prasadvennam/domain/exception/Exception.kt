package com.prasadvennam.domain.exception

sealed class MovieVerseException() : Exception() {
    object BadRequestException : MovieVerseException()
    object UnauthorizedRequestException : MovieVerseException()
    object ForbiddenRequestException : MovieVerseException()
    object NotFoundException : MovieVerseException()
    object ServerErrorException : MovieVerseException()
    object UnknownException : MovieVerseException()
    object NoInternetException : MovieVerseException()
    object TooMuchTimeException : MovieVerseException()
    object ServerNotFoundException : MovieVerseException()
    object ServiceUnavailableException : MovieVerseException()
    object TooManyRequestsException : MovieVerseException()
    object NullException : MovieVerseException()
    object AddMediaItemToCollectionException : MovieVerseException()
    object DeleteMediaItemFromCollectionException : MovieVerseException()
    object ClearCollectionException : MovieVerseException()
    object NotAllowedUserException : MovieVerseException()
}