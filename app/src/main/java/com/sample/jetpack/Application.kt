package com.sample.jetpack

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author shuxq
 * @date 2020/5/26.
 * description:
 */
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}