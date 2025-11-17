package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common

object ErrorHandler {
    fun map(throwable: Throwable, retryAction: (() -> Unit)? = null): UIError {
        // In a real app, you would have more sophisticated error mapping
        return UIError(
            code = "UNKNOWN",
            title = "An unexpected error occurred",
            message = throwable.message ?: "Something went wrong",
            retryAction = retryAction
        )
    }
}
