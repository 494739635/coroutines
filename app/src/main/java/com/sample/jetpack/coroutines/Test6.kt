package com.sample.jetpack.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

/**
 * @author shuxq
 * @date 2020/7/17.
 * description:挂起函数不会阻塞线程
 */
fun main() {
    /*协程的delay()挂起函数会暂停协程一定时间，并不会阻塞协程所在线程，但是Thread.sleep()函数会阻塞线程。*/
    // 创建一个单线程的协程调度器，下面两个协程都运行在这同一线程上
    val coroutineDispatcher = newSingleThreadContext("sxq")
    // 启动协程 1
    GlobalScope.launch(coroutineDispatcher) {
        println("the first coroutine")
        delay(200)
        println("the first coroutine")
    }
    // 启动协程 2
    GlobalScope.launch(coroutineDispatcher) {
        println("the second coroutine")
        delay(100)
        println("the second coroutine")
    }
    // 保证 main 线程存活，确保上面两个协程运行完成
    Thread.sleep(500)
}