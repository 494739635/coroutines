package com.sample.jetpack.retrofit

import android.widget.Toast
import androidx.lifecycle.*
import com.sample.jetpack.Application
import com.sample.jetpack.retrofit.enity.LoginResponseBean
import com.sample.jetpack.retrofit.enity.UserInfo
import com.sample.jetpack.retrofit.network.UserNetwork
import com.sample.jetpack.retrofit.util.Settings
import kotlinx.coroutines.launch

/**
 * @author shuxq
 * @date 2020/5/26.
 * description:
 */
class UserViewModel(private val repository: UserRepository) : ViewModel() {


    fun login(phone: String, code: String): LiveData<LoginResponseBean> = liveData {
        if (phone.isNullOrEmpty() || code.isNullOrEmpty()) {
            Toast.makeText(Application.context, "请输入东西", Toast.LENGTH_SHORT).show()
        } else {
            val bean = repository.loginByMobile(phone, code)
            Settings.Account.token = bean.id_token!!
            emit(bean)
        }
    }

    fun getUserInfo(userId: Long): LiveData<UserInfo> = liveData {
        emit(repository.getUserInfo(userId))
    }
}

object UserVMFactory : ViewModelProvider.Factory {

    private val repository = UserRepository.getInstance(UserNetwork.getInstance())
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}