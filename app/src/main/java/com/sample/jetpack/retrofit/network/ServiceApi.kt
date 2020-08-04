package com.sample.jetpack.retrofit.network

import com.sample.jetpack.retrofit.enity.CommonResult
import com.sample.jetpack.retrofit.enity.LoginResponseBean
import com.sample.jetpack.retrofit.enity.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @author shuxq
 * @date 2020/5/26.
 * description:
 */
interface ServiceApi {

    /**
     * 手机登录
     */
    @POST("app/auth-mobile")
    fun loginMobile(@Body map: Map<String, String>): Call<CommonResult<LoginResponseBean>>


    /**
     * 获取用户信息
     */
    @GET("app/user/home-page")
    fun getUserInfo(@Query("userId") userId: Long): Call<CommonResult<UserInfo>>
}