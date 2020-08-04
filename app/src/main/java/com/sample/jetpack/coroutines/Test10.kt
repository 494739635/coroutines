package com.sample.jetpack.coroutines

import kotlinx.coroutines.*

/**
 * @author shuxq
 * @date 2020/7/30.
 * description: 全局协程像守护线程
 *
 */
fun main() = runBlocking {
    //在 GlobalScope 中启动的活动协程并不会使进程保活。它们就像守护线程。
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // 在延迟后退出
}



