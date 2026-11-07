package com.siyu.footwalk.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequestDto(
    val name: String,
    val email: String,
    val password: String
)

@Serializable
data class LoginRequestDto(
    val email: String,
    val password: String
)

@Serializable
data class UserDto(
    val id: Int,
    val name: String,
    val email: String
)

@Serializable
data class AuthResponseDto(
    val token: String,
    val user: UserDto
)

@Serializable
data class ErrorDetailDto(
    val field: String = "",
    val message: String = ""
)

@Serializable
data class ErrorDto(
    val error: String = "",
    val details: List<ErrorDetailDto> = emptyList()
)