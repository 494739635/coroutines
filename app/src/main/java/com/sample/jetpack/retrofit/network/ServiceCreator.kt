package com.sample.jetpack.retrofit.network

import android.util.Log
import com.sample.jetpack.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 60L
private const val TAG = "sxq"

object ServiceCreator {

    private const val BASE_URL = "https://cat.yztest.top/api/"

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.e(TAG, message)
            }
        }).also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(AuthorizationInterceptor())
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS).also {
            if (BuildConfig.DEBUG) {
                it.addInterceptor(httpLoggingInterceptor)
            }
        }.build()

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())


    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}