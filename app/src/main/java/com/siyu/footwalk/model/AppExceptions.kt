package com.siyu.footwalk.model

//Errores propios de la app
open class AppException(message: String, val code: Int? = null) : Exception(message)

class SessionExpiredException : AppException("Tu sesión expiró. Inicia sesión de nuevo.", 401)