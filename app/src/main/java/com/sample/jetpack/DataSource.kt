package com.sample.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * @author shuxq
 * @date 2020/5/18.
 * description:数据来源类，可来自网络或者数据库
 */
class DataSource(private val ioDispatcher: CoroutineDispatcher) : DataView {

    private val userInfo = UserInfo()

    override fun getUserInfo(): LiveData<UserInfo> = liveData {
        userInfo.userName = "sxq"
        userInfo.userSex = "man"
        userInfo.userAge = 26
        emit(userInfo)
    }

    override fun getUserAge(): LiveData<Int> = liveData {
            emit(userInfo.userAge)
    }

    override suspend fun addUserAge() {
        withContext(Dispatchers.Main) {
            userInfo.userAge = userInfo.userAge + 1
            _cachedData.value = userInfo.userAge
        }
    }
    private val _cachedData = MutableLiveData(getUserInfo().value?.userAge)
    override val cachedData: LiveData<Int?> = _cachedData

}

interface DataView {
    fun getUserInfo(): LiveData<UserInfo>
    fun getUserAge(): LiveData<Int>
    val cachedData: LiveData<Int?>
    suspend fun addUserAge()
}