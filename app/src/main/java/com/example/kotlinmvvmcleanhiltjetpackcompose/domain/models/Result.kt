package domain.models

/**
 * A sealed class representing a result of an operation, either Success or Failure.
 */
sealed class Result<out T, out E> {
    data class Success<T>(val value: T) : Result<T, Nothing>()
    data class Failure<E>(val error: E) : Result<Nothing, E>()
}
