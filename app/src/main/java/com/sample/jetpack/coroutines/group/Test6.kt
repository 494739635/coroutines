package com.sample.jetpack.coroutines.group

/**
 * @author shuxq
 * @date 2020/8/4.
 * description:
 */
import kotlinx.coroutines.*

/**
 * 结构化并发的时候，如果一个子协程发生错误，此时它的父协程及同并发的协程都会被取消
 */
fun main() = runBlocking<Unit> {
    try {
        failedConcurrentSum()
    } catch(e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE) // 模拟一个长时间的运算
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }
    one.await() + two.await()
}
