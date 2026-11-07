package com.siyu.footwalk.data.repository


import com.siyu.footwalk.model.AuthSession
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val session: Flow<AuthSession?>
    suspend fun register(name: String, email: String, password: String)
    suspend fun login(email: String, password: String)
    suspend fun logout()
}