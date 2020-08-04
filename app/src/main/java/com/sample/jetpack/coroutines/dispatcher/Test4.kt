package com.sample.jetpack.coroutines.dispatcher

/**
 * @author shuxq
 * @date 2020/8/4.
 * description:
 */
import kotlinx.coroutines.delay
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 在不同线程间跳转
 */
fun main() {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                log("Started in ctx1")
                withContext(ctx2) {
                    log("Working in ctx2")
                }
                log("Back to ctx1")
            }
        }
    }
    val t3 = newSingleThreadContext("Ctx3").also {
        log("this is ctx3")
    }
    runBlocking {
        withContext(t3) {
            log("Started in ctx3")
        }
    }
}