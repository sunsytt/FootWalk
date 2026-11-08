package com.siyu.footwalk.data.mapper

import com.siyu.footwalk.data.remote.dto.AuthResponseDto
import com.siyu.footwalk.data.remote.dto.UserDto
import com.siyu.footwalk.model.AuthSession
import com.siyu.footwalk.model.User

fun UserDto.toModel() = User(id = id, name = name, email = email)

fun AuthResponseDto.toModel() = AuthSession(token = token, user = user.toModel())