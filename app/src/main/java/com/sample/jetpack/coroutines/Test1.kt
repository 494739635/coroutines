package com.sample.jetpack.coroutines

/**
 * @author shuxq
 * @date 2020/7/17.
 * description:
 */
fun main() {
    val startTime = System.currentTimeMillis()

    /*多耗时任务，每个任务都依赖前一个任务情况*/
    val name = getName1()
    val age = getAge1(name)
    val info = getInfo(age)
    print(info + "\n用时：" + (System.currentTimeMillis() - startTime))
}

fun getName1(): Params1 {
    Thread.sleep(2000)
    return Params1("sxq")
}

fun getAge1(p1: Params1): Params2 {
    Thread.sleep(3000)
    return Params2(28, p1)
}