package com.sample.jetpack.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author shuxq
 * @date 2020/7/21.
 * description:
 */
fun main(){
    //下节课内容：
    // 1:Coroutines使用状态机处理挂起点


    GlobalScope.launch() {

    }

    // 每一个挂起点和初始挂起点对应的 Continuation 都会转化为一种状态，协程恢复只是跳转到下一种状态中。
    // 挂起函数将执行过程分为多个 Continuation 片段，并且利用状态机的方式保证各个片段是顺序执行的
    // https://upload-images.jianshu.io/upload_images/6193835-9c20744385575755.png?imageMogr2/auto-orient/strip|imageView2/2/format/webp

}



