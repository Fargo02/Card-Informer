package com.example.cardinformer.core.utils

sealed class NetworkError(override val message: String) : Throwable(message = message) {

    class ServerError(message: String) : NetworkError("Error communicating with the server message: $message")

    class NoData : NetworkError("Empty response body")

    class NoInternet : NetworkError("No internet connection")
}
