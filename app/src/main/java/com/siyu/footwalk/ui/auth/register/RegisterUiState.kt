package com.siyu.footwalk.ui.auth.register


data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val nameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmError: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val registered: Boolean = false,
)