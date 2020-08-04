package com.sample.jetpack.coroutines.cancel

/**
 * @author shuxq
 * @date 2020/8/3.
 * description:
 */
import kotlinx.coroutines.*

/**
 * runBlocking 启动的协程会等待其子任务全部运行完之后才会结束
 * 使用job对象的cancel取消协程，也可以使用 cancelAndJoin 它合并了对 cancel 以及 join 的调用
 */
fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancel() // 取消该作业
    job.join() // 等待作业执行结束
    println("main: Now I can quit.")
}