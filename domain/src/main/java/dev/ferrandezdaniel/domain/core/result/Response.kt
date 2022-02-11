package dev.ferrandezdaniel.domain.core.result

sealed class Response<T> {
    class Success<T>(val value: T) : Response<T>()
    class Failure<T>(var exception: Throwable) : Response<T>()
}
