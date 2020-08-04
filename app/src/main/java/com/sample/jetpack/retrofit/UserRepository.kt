package com.sample.jetpack.retrofit

import com.sample.jetpack.retrofit.enity.UserInfo
import com.sample.jetpack.retrofit.network.UserNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * @author shuxq
 * @date 2020/5/26.
 * description:
 */
class UserRepository private constructor(private val network: UserNetwork) {

    suspend fun loginByMobile(phone: String, code: String) = withContext(Dispatchers.IO) {
        val map = HashMap<String, String>()
        map["mobile"] = phone
        map["code"] = code
        map["smsId"] = ""
        val fetchLoginResponseBean = network.fetchLoginResponseBean(map)
        fetchLoginResponseBean.data
    }

    suspend fun getUserInfo(userId: Long): UserInfo = withContext(Dispatchers.IO) {
        val data = network.fetchUserInfo(userId).data
        data
    }

    companion object {

        private lateinit var instance: UserRepository

        fun getInstance(network: UserNetwork): UserRepository {
            if (!::instance.isInitialized) {
                synchronized(UserRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = UserRepository(network)
                    }
                }
            }
            return instance
        }

    }

}