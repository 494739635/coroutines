package com.sample.jetpack.coroutines.timeout

/**
 * @author shuxq
 * @date 2020/8/3.
 * description:
 */
import kotlinx.coroutines.*

/**
 * withTimeout 抛出了 TimeoutCancellationException，它是 CancellationException 的子类
 */
fun main() = runBlocking {
    withTimeout(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
}