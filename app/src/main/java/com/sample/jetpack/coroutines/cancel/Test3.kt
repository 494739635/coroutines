package com.sample.jetpack.coroutines.cancel

/**
 * @author shuxq
 * @date 2020/8/3.
 * description:
 */
import kotlinx.coroutines.*

/**
 * 使计算代码可取消
 * 两种方式使计算代码可取消
 * 1：定期调用挂起函数来检查取消，比如 yield 或者 delay
 * 2：根据isActive(一个可以被使用在 CoroutineScope 中的扩展属性)显示的检查取消状态
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // 可以被取消的计算循环
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并等待它结束
    println("main: Now I can quit.")
}