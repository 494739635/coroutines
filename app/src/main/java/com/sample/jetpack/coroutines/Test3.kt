package com.sample.jetpack.coroutines

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.concurrent.CompletableFuture

/**
 * @author shuxq
 * @date 2020/7/17.
 * description:
 */
@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    /*使用Future将多个任务串联起来，可以避免多层嵌套的问题(仅限Java8或以上)  或者使用promise*/
    getInfo3()
}

@RequiresApi(Build.VERSION_CODES.N)
fun getName3(): CompletableFuture<Params1> {
    val future = CompletableFuture<Params1>()
    Thread(Runnable {
        Thread.sleep(2000)
        future.complete(Params1("sxq"))
    }).start()
    return future
}

@RequiresApi(Build.VERSION_CODES.N)
fun getAge3(p1: Params1): CompletableFuture<Params2> {
    val future = CompletableFuture<Params2>()
    Thread(Runnable {
        Thread.sleep(3000)
        future.complete(Params2(28, p1))
    }).start()
    return future
}

@RequiresApi(Build.VERSION_CODES.N)
fun getInfo3(){
    getName3()
        .thenCompose {
            getAge3(it)
        }
        .thenAccept {
            val info = getInfo(it)
            print(info)
        }
}