package com.siyu.footwalk.model

import java.time.LocalDate

data class User(
    val id: Int,
    val name: String,
    val email: String
)

data class AuthSession(
    val token: String,
    val user: User
)

data class Walk(
    val id: Int,
    val name: String,
    val date: LocalDate,
    val steps: Int,
    val distanceKm: Double,
    val durationMinutes: Int,
    val notes: String?,
)

// Datos para crear o editar (todavía sin id)
data class WalkInput(
    val name: String,
    val date: LocalDate,
    val steps: Int,
    val distanceKm: Double?,
    val durationMinutes: Int,
    val notes: String?,
)

data class TodaySummary(
    val date: LocalDate,
    val steps: Int,
    val distanceKm: Double,
    val activeMinutes: Int,
    val goalSteps: Int,
    val progress: Int,
)

data class WalksOverview(
    val today: TodaySummary,
    val walks: List<Walk>
)
