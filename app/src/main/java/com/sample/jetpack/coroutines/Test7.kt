package com.sample.jetpack.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author shuxq
 * @date 2020/7/17.
 * description:
 */
fun main(){
    /*协程运行在哪些线程上，挂起函数回复协程后运行在哪个线程上*/
    /*
    * 协程的所属的线程调度主要是由协程的CoroutineDispatcher控制，
    * CoroutineDispatcher可以指定协程运行在某一特定线程上、运作在线程池中或者不指定所运行的线程。
    * 所以协程调度器可以分为Confined dispatcher和Unconfined dispatcher，Dispatchers.Default、Dispatchers.IO和Dispatchers.Main属于Confined dispatcher，
    * 都指定了协程所运行的线程或线程池，挂起函数恢复后协程也是运行在指定的线程或线程池上的，
    * 而Dispatchers.Unconfined属于Unconfined dispatcher，
    * 协程启动并运行在 Caller Thread 上，但是只是在第一个挂起点之前是这样的，挂起恢复后运行在哪个线程完全由所调用的挂起函数决定
    */
    runBlocking {
        launch {
            // 默认继承 parent coroutine 的 CoroutineDispatcher，指定运行在 main 线程
            println("1  main runBlocking: I'm working in thread ${Thread.currentThread().name}")
            delay(100)
            println("2  main runBlocking: After delay in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) {
            println("3  Unconfined      : I'm working in thread ${Thread.currentThread().name}")
            delay(100)
            println("4  Unconfined      : After delay in thread ${Thread.currentThread().name}")
        }
    }
}