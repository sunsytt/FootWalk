package com.siyu.footwalk.data.remote.api

import com.siyu.footwalk.data.remote.dto.WalkDto
import com.siyu.footwalk.data.remote.dto.WalkRequestDto
import com.siyu.footwalk.data.remote.dto.WalksResponseDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface WalkApi {
    @GET("walks")
    suspend fun getWalks(@Query("date") date: String): WalksResponseDto

    @GET("walks/{id}")
    suspend fun getWalk(@Path("id") id: Int): WalkDto

    @POST("walks")
    suspend fun createWalk(@Body body: WalkRequestDto): WalkDto

    @PUT("walks/{id}")
    suspend fun updateWalk(@Path("id") id: Int, @Body body: WalkRequestDto): WalkDto

    @DELETE("walks/{id}")
    suspend fun deleteWalk(@Path("id") id: Int)
}