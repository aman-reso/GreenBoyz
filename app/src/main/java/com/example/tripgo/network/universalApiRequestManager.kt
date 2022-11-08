package com.example.tripgo.network

import io.ktor.client.features.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

//generic function
suspend fun <T> universalApiRequestManager(apiCall: suspend () -> T): ResultWrapper<T> {
    return withContext(Dispatchers.IO) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> {
                    ResultWrapper.NetworkError
                }
                is ClientRequestException ->{
                    ResultWrapper.GenericError(throwable.response.status.value,null)
                }
                else -> {
                    ResultWrapper.GenericError(null, null)
                }
            }
        }
    }
}