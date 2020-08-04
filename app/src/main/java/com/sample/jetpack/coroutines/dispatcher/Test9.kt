package com.sample.jetpack.coroutines.dispatcher

/**
 * @author shuxq
 * @date 2020/8/4.
 * description:
 */
import kotlinx.coroutines.*

/**
 * 组合上下文中的元素
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}