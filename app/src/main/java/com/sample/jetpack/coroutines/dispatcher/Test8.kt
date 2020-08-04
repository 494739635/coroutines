package com.sample.jetpack.coroutines.dispatcher

/**
 * @author shuxq
 * @date 2020/8/4.
 * description:
 */
import kotlinx.coroutines.*

/**
 * 命名协程以用于调试
 */
fun main() = runBlocking(CoroutineName("main")) {
    log("Started main coroutine")
    // 运行两个后台值计算
    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        log("Computing v1")
        252
    }
    val v2 = async(CoroutineName("v2coroutine")) {
        delay(1000)
        log("Computing v2")
        6
    }
    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}