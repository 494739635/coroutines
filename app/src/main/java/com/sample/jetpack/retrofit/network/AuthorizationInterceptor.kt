package com.sample.jetpack.retrofit.network

import com.sample.jetpack.retrofit.util.Settings
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json; charset=UTF-8")
            .addHeader("Authorization", Settings.Account.token)
            .addHeader("Accept", "*/*")
            .build()
        return chain.proceed(request)
    }
}