package com.sample.jetpack.extend

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.animation.addListener
import androidx.fragment.app.Fragment

/**
 * @author shuxq
 * @date 2020/10/12.
 * description:
 */
// 扩展函数
inline fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
inline fun Fragment.toast(msg: String) {
    Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
}
inline fun Activity.toast(msg:String){
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
// 调用
//toast("hello toast")
//reified修饰类型后，我们就能够在函数内部使用相关类型了
inline fun <reified T : Activity> Activity.startActivity(extras: Bundle) {
    startActivity(Intent(this, T::class.java).putExtras(extras))
}
/*inline 用于修饰函数，被其修饰的函数在被调用的地方会将函数内的方法体复制到调用处*/
/*
优点:1：会减少函数调用的次数开销，:
     2：会减少对象的生成。当方法中，有一个参数是 lambda 的时候，使用 inline 的方法，可以减少对象的生成
缺点:1:对于一个 public 的 inline 方法，他不可以引用类的私有变量
    private val happy = true
    inline fun testNonPrivateField() {
        println("happy = ${happy}")
    }
    2:inline 方法会对流程造成非常隐晦的影响
*/
/*fun main() {
    println("Start of main")
    multiplyByTwo(5) {
        println("Result is: $it")
        return
    }
    println("End of main")
}

inline fun multiplyByTwo(num: Int,
                  lambda: (result: Int) -> Unit): Int {
    val result = num * 2
    lambda.invoke(result)
    return result
}*/
/*noinline修饰的是 inline 方法中的 lambda 参数。noinline 用于我们不想让 inline 特性作用到 inline 方法的某些 lambda 参数上的场景*/

fun main() {
    val methodName = "main"
    multiplyByTwo(5) {
            result: Int -> println("call method $methodName, Result is: $result")
    }
}

inline fun multiplyByTwo(
    num: Int,
    noinline lambda: (result: Int) -> Unit): Int {
    val result = num * 2
    lambda.invoke(result)
    return result
}

/*如果我们既想让 lambda 也被 inline，但是又不想让 lambda 对调用方的控制流程产生影响*/

/*crossinline 就是为了处理这种情况而产生的。crossinline 保留了 inline 特性，
但是如果想在传入的 lambda 里面 return 的话，就会报错。return 只能 return 当前的这个 lambda*/

/*总结
inline 关键字的作用，是把 inline 方法以及方法中的 lambda 参数在编译期间复制到调用方，
进而减少函数调用以及对象生成。对于有时候我们不想让 inline 关键字对 lambda 参数产生影响，
可以使用 noline 关键字。如果想 lambda 也被 inline，但是不影响调用方的控制流程，那么就要是用 crossinline*/
