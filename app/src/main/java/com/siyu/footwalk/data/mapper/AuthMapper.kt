package com.siyu.footwalk.data.mapper

import com.siyu.footwalk.data.remote.dto.AuthResponseDto
import com.siyu.footwalk.data.remote.dto.UserDto

fun UserDto.toModel() = User(id = id, name = name, email = email)

fun AuthResponseDto.toModel() = AuthSession(token = token, user = user.toModel())