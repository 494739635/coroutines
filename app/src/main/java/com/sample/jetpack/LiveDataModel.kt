package com.sample.jetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author shuxq
 * @date 2020/5/18.
 * description:
 */
class LiveDataModel(
    private val dataSource: DataSource
) : ViewModel() {
    val userInfo = dataSource.getUserInfo()

    val userAge = dataSource.getUserAge()

    fun addUserAge() {
        // Launch a coroutine that reads from a remote data source and updates cache
        viewModelScope.launch {
            dataSource.addUserAge()
        }
    }
}

object LiveDataVMFactory:ViewModelProvider.Factory{

    private val dataSource = DataSource(Dispatchers.IO)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LiveDataModel(dataSource) as T
    }
}