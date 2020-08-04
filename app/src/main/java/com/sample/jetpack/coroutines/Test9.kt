package com.sample.jetpack.coroutines

import kotlinx.coroutines.*

/**
 * @author shuxq
 * @date 2020/7/30.
 * description: 协程很轻量
 */
fun main() = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}



