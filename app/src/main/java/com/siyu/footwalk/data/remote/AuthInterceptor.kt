package com.siyu.footwalk.data.remote

import com.siyu.footwalk.data.session.SessionStorage
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

//Interceptor de autenticación
class AuthInterceptor(private val sessionStorage: SessionStorage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Los interceptores de OkHttp corren en un hilo de red, por eso runBlocking es aceptable aquí
        val token = runBlocking { sessionStorage.session.first()?.token }
        val request = if (token != null) {
            chain.request().newBuilder().header("Authorization", "Bearer $token").build()
        } else {
            chain.request()
        }
        return chain.proceed(request)
    }
}