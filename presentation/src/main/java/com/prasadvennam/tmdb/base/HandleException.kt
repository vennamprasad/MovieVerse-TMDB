package com.prasadvennam.tmdb.base

import com.prasadvennam.tmdb.presentation.R
import com.prasadvennam.domain.exception.MovieVerseException

fun Exception.handleException() : Int{
    return when(this){
        is MovieVerseException -> when(this){
            MovieVerseException.BadRequestException -> R.string.bad_request
            MovieVerseException.AddMediaItemToCollectionException -> R.string.faild_to_add_item_please_try_again_later
            MovieVerseException.ClearCollectionException -> R.string.faild_to_clear_collection_please_try_again_later
            MovieVerseException.DeleteMediaItemFromCollectionException -> R.string.faild_to_delete_item_from_collection_please_try_again_later
            MovieVerseException.ForbiddenRequestException -> R.string.forbidden_request
            MovieVerseException.NoInternetException -> R.string.no_internet_connection
            MovieVerseException.NotAllowedUserException -> R.string.not_allowed_user
            MovieVerseException.NotFoundException -> R.string.not_found
            MovieVerseException.NullException -> R.string.not_found
            MovieVerseException.ServerErrorException -> R.string.server_error
            MovieVerseException.ServerNotFoundException -> R.string.server_not_found
            MovieVerseException.ServiceUnavailableException -> R.string.service_unavailable
            MovieVerseException.TooManyRequestsException -> R.string.too_many_requests
            MovieVerseException.TooMuchTimeException -> R.string.too_much_time
            MovieVerseException.UnauthorizedRequestException -> R.string.unauthorized_request
            MovieVerseException.UnknownException -> R.string.error_occurred
        }
        else -> R.string.error_occurred
    }
}