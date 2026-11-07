package com.siyu.footwalk.data.session

import com.siyu.footwalk.model.AuthSession
import kotlinx.coroutines.flow.Flow

//Sesión detrás de una abstracción
interface SessionStorage {
    val session: Flow<AuthSession?>
    suspend fun save(session: AuthSession)
    suspend fun clear()
}