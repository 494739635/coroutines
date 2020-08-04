package com.sample.jetpack.coroutines.timeout

/**
 * @author shuxq
 * @date 2020/8/3.
 * description:
 */
import kotlinx.coroutines.*

/**
 *  withTimeoutOrNull 通过返回 null 来进行超时操作，从而替代抛出一个异常
 */
fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
//        "Done" // 在它运行得到结果之前取消它
    }
    println("Result is $result")
}