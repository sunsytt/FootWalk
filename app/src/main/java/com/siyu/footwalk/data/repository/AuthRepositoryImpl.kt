package com.siyu.footwalk.data.repository

import com.siyu.footwalk.data.mapper.toModel
import com.siyu.footwalk.data.remote.api.AuthApi
import com.siyu.footwalk.data.remote.dto.LoginRequestDto
import com.siyu.footwalk.data.remote.dto.RegisterRequestDto
import com.siyu.footwalk.data.remote.safeApiCall
import com.siyu.footwalk.data.session.SessionStorage
import com.siyu.footwalk.model.AuthSession
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val sessionStorage: SessionStorage,
    private val json: Json,
) : AuthRepository {

    override val session: Flow<AuthSession?> = sessionStorage.session

    override suspend fun register(name: String, email: String, password: String) {
        val response = safeApiCall(json) { api.register(RegisterRequestDto(name, email, password)) }
        sessionStorage.save(response.toModel())
    }

    override suspend fun login(email: String, password: String) {
        val response = safeApiCall(json) { api.login(LoginRequestDto(email, password)) }
        sessionStorage.save(response.toModel())
    }

    override suspend fun logout() = sessionStorage.clear()
}