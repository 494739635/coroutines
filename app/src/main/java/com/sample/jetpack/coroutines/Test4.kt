package com.sample.jetpack.coroutines

/**
 * @author shuxq
 * @date 2020/7/17.
 * description:
 */
fun main() {
    val startTime = System.currentTimeMillis()

    /*使用Rx操作符*/
    /*Single.fromCallable { getName4() }
        .map { p1 -> getAge4(p1) }
        .subscribe(
            {
                val info = getInfo(it)
                print(info)
            }, // onSuccess
            { e -> e.printStackTrace() } // onError
        )*/
}

fun getName4(): Params1 {
    Thread.sleep(2000)
    return Params1("sxq")
}

fun getAge4(p1: Params1): Params2 {
    Thread.sleep(3000)
    return Params2(28, p1)
}
