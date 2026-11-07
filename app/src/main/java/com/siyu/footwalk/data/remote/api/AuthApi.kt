package com.siyu.footwalk.data.remote.api

import com.siyu.footwalk.data.remote.dto.AuthResponseDto
import com.siyu.footwalk.data.remote.dto.LoginRequestDto
import com.siyu.footwalk.data.remote.dto.RegisterRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/register")
    suspend fun register(@Body body: RegisterRequestDto): AuthResponseDto

    @POST("auth/login")
    suspend fun login(@Body body: LoginRequestDto): AuthResponseDto
}