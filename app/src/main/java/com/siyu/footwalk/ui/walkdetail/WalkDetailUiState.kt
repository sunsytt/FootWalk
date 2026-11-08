package com.siyu.footwalk.ui.walkdetail

import com.siyu.footwalk.model.Walk

sealed interface WalkDetailStatus {
    data object Loading : WalkDetailStatus
    data class Error(val message: String) : WalkDetailStatus
    data class Loaded(val walk: Walk) : WalkDetailStatus
}

data class WalkDetailUiState(
    val status: WalkDetailStatus = WalkDetailStatus.Loading,
    val showDeleteDialog: Boolean = false,
    val isDeleting: Boolean = false,
    val errorMessage: String? = null,
    val deleted: Boolean = false,
)