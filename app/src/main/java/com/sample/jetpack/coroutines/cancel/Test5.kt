package com.sample.jetpack.coroutines.cancel

/**
 * @author shuxq
 * @date 2020/8/3.
 * description:
 */

import kotlinx.coroutines.*

/**
 * 在finally 如果想要调用一个挂起函数会抛出 CancellationException，因为这里持续运行的代码是可以被取消的
 * 如果想要在finally调用挂起函数可以通过 withContext 函数以及 NonCancellable 上下文
 */
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并等待它结束
    println("main: Now I can quit.")
}