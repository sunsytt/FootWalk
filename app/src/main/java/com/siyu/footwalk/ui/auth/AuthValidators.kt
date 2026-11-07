package com.siyu.footwalk.ui.auth

import android.util.Patterns

internal fun validateEmail(email: String): String? = when {
    email.isBlank() -> "El correo es obligatorio"
    !Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches() -> "Formato de correo inválido"
    else -> null
}

internal fun validateNewPassword(password: String): String? = when {
    password.isEmpty() -> "La contraseña es obligatoria"
    password.length < 8 -> "Mínimo 8 caracteres"
    !password.any { it.isUpperCase() } -> "Debe incluir una mayúscula"
    !password.any { it.isDigit() } -> "Debe incluir un número"
    else -> null
}