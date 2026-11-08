package com.siyu.footwalk.ui.home

import com.siyu.footwalk.model.WalksOverview

sealed interface HomeStatus {
    data object Loading : HomeStatus
    data class Error(val message: String) : HomeStatus
    data class Loaded(val overview: WalksOverview) : HomeStatus
}

data class HomeUiState(
    val userName: String = "",
    val status: HomeStatus = HomeStatus.Loading,
)