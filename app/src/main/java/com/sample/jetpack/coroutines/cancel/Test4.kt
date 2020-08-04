package com.sample.jetpack.coroutines.cancel

/**
 * @author shuxq
 * @date 2020/8/3.
 * description:
 */
import kotlinx.coroutines.*

/**
 * 在 finally 中释放资源
 * 下面的job.cancelAndJoin()抛出 CancellationException，且被挂起函数delay检查到因此任务结束
 */
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并且等待它结束
    println("main: Now I can quit.")
}