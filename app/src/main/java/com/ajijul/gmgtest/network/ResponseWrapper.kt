package com.ajijul.gmgtest.network

sealed class ResponseWrapper<out T> {

    data class Success<T>(
        val data: T? = null,
        val message: String? = null

    ) : ResponseWrapper<T>()

    data class Error(
        var code: Int? = null,
        var message: String? = null

    ) : ResponseWrapper<Nothing>()

    class Loading : ResponseWrapper<Nothing>()

}