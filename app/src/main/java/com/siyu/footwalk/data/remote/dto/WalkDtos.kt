package com.siyu.footwalk.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WalkDto(
    val id: Int,
    val name: String,
    val date: String,
    val steps: Int,
    val distanceKm: Double,
    val durationMinutes: Int,
    val notes: String? = null,
)

@Serializable
data class WalkRequestDto(
    val name: String,
    val date: String,
    val steps: Int,
    val distanceKm: Double? = null,
    val durationMinutes: Int,
    val notes: String? = null,
)

@Serializable
data class TodayDto(
    val date: String,
    val steps: Int,
    val distanceKm: Double,
    val activeMinutes: Int,
    val goalSteps: Int,
    val progress: Int,
)

@Serializable
data class WalksResponseDto(
    val today: TodayDto,
    val walks: List<WalkDto>
)