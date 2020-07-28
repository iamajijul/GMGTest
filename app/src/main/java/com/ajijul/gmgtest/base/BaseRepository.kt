package com.ajijul.gmgtest.base

import com.ajijul.gmgtest.network.ResponseWrapper
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

open class BaseRepository {
    companion object {
        private const val TAG = "BaseRemoteRepository"
        private const val MESSAGE_KEY = "message"
        private const val ERROR_KEY = "error"
    }

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResponseWrapper<T> {
        return withContext(IO) {
            try {
                ResponseWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ResponseWrapper.Error()

                    is HttpException -> {
                        val code =throwable.code()
                        val errorMessage = convertErrorBody(throwable)
                        ResponseWrapper.Error(code,errorMessage)
                    }
                    else ->{
                        ResponseWrapper.Error()
                    }
                }
            }
        }
    }

    private fun convertErrorBody(throwable: HttpException): String? {

        return try {
            throwable.response()?.errorBody()?.string()?.let {
                val jsonObject = JSONObject(it)
                when {
                    jsonObject.has(MESSAGE_KEY) -> jsonObject.getString(MESSAGE_KEY)
                    jsonObject.has(ERROR_KEY) -> jsonObject.getString(ERROR_KEY)
                    else -> "Something wrong happened"
                }
            }

        } catch (e: Exception) {
            "Something wrong happened"
        }

    }
}