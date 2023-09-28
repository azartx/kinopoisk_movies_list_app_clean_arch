package com.solo4.kinoapp.data.network

import com.solo4.kinoapp.common.utils.API_API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request().newBuilder()
            .addHeader("X-API-KEY", API_API_KEY)
            .build())
    }
}