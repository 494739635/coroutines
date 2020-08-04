package com.sample.jetpack.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author shuxq
 * @date 2020/7/17.
 * description:
 */

fun main() {
    /*使用协程处理异步多任务*/
    val startTime = System.currentTimeMillis()
    val job = GlobalScope.launch {
        println("基本信息：")
        val p1 = getName5()
        println("姓名：" + p1.name)
        val p2 = getAge5(p1)
        println("年龄：" + p2.age)
        print("用时：" +(System.currentTimeMillis() - startTime))
    }
    Thread.sleep(6000)
}

suspend fun getName5(): Params1 {
    delay(2000)
    return Params1("sxq")
}

suspend fun getAge5(p1: Params1): Params2 {
    delay(3000)
    return Params2(28, p1)
}