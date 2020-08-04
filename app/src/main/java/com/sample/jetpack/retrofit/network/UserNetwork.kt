package com.sample.jetpack.retrofit.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class UserNetwork {

    private val placeService = ServiceCreator.create(ServiceApi::class.java)

    suspend fun fetchLoginResponseBean(map: Map<String, String>) = placeService.loginMobile(map).await()

    suspend fun fetchUserInfo(userId: Long) = placeService.getUserInfo(userId).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    companion object {

        private var network: UserNetwork? = null

        fun getInstance(): UserNetwork {
            if (network == null) {
                synchronized(UserNetwork::class.java) {
                    if (network == null) {
                        network = UserNetwork()
                    }
                }
            }
            return network!!
        }

    }

}