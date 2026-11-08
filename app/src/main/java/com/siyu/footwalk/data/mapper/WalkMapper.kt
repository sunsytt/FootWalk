package com.siyu.footwalk.data.mapper

import com.siyu.footwalk.data.remote.dto.TodayDto
import com.siyu.footwalk.data.remote.dto.WalkDto
import com.siyu.footwalk.data.remote.dto.WalkRequestDto
import com.siyu.footwalk.data.remote.dto.WalksResponseDto
import com.siyu.footwalk.model.TodaySummary
import com.siyu.footwalk.model.Walk
import com.siyu.footwalk.model.WalkInput
import com.siyu.footwalk.model.WalksOverview
import java.time.LocalDate

fun WalkDto.toModel() = Walk(
    id = id,
    name = name,
    date = LocalDate.parse(date),
    steps = steps,
    distanceKm = distanceKm,
    durationMinutes = durationMinutes,
    notes = notes,
)

fun WalkInput.toDto() = WalkRequestDto(
    name = name,
    date = date.toString(),
    steps = steps,
    distanceKm = distanceKm,
    durationMinutes = durationMinutes,
    notes = notes,
)

fun TodayDto.toModel() = TodaySummary(
    date = LocalDate.parse(date),
    steps = steps,
    distanceKm = distanceKm,
    activeMinutes = activeMinutes,
    goalSteps = goalSteps,
    progress = progress,
)

fun WalksResponseDto.toModel() =
    WalksOverview(today = today.toModel(), walks = walks.map { it.toModel() })