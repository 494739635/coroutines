package com.sample.jetpack.coroutines.dispatcher

/**
 * @author shuxq
 * @date 2020/8/4.
 * description:
 */
import kotlinx.coroutines.*

/**
 * 一个父协程总是等待所有的子协程执行结束。父协程并不显式的跟踪所有子协程的启动，并且不必使用 Job.join 在最后的时候等待它们
 * 一般协程会先执行父协程块中的代码，然后依次由外层向内执行
 */
fun main() = runBlocking<Unit> {
    // 启动一个协程来处理某种传入请求（request）
    val request = launch {
        repeat(3) { i -> // 启动少量的子作业
            launch  {
                delay((i + 1) * 200L) // 延迟 200 毫秒、400 毫秒、600 毫秒的时间
                println("Coroutine $i is done")
            }
        }
        launch {
            launch {
                launch {
                    println("1")
                }
                println("2")
            }
            println("3")
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    request.join() // 等待请求的完成，包括其所有子协程
    println("Now processing of the request is complete")
}