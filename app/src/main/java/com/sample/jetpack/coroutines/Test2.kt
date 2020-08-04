package com.sample.jetpack.coroutines

/**
 * @author shuxq
 * @date 2020/7/17.
 * description:
 */
fun main() {
    val startTime = System.currentTimeMillis()

    /*回调的方式处理异步耗时任务*/
    getName2 { p1 ->
        getAge2(p1) {
            val info = getInfo(it)
            print(info + "\n用时：" + (System.currentTimeMillis() - startTime))
        }
    }
}

fun getName2(p1Call: (Params1) -> Unit) {
    Thread.sleep(2000)
    p1Call(Params1("sxq"))
}

fun getAge2(p1: Params1, p2Call: (Params2) -> Unit) {
    Thread.sleep(3000)
    p2Call(Params2(28, p1))
}