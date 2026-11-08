package com.siyu.footwalk.ui.walkform

import java.time.LocalDate

data class WalkFormUiState(
    val isEditing: Boolean = false,
    val isLoadingWalk: Boolean = false,
    val loadError: String? = null,
    val name: String = "",
    val date: LocalDate = LocalDate.now(),
    val steps: String = "",
    val distanceKm: String = "",
    val durationMinutes: String = "",
    val notes: String = "",
    val nameError: String? = null,
    val dateError: String? = null,
    val stepsError: String? = null,
    val distanceError: String? = null,
    val durationError: String? = null,
    val notesError: String? = null,
    val isSaving: Boolean = false,
    val errorMessage: String? = null,
    val savedMessage: String? = null,
)