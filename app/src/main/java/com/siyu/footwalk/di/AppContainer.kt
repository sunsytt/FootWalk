package com.siyu.footwalk.di

import android.content.Context
import com.siyu.footwalk.data.remote.AuthInterceptor
import com.siyu.footwalk.data.remote.api.AuthApi
import com.siyu.footwalk.data.remote.api.WalkApi
import com.siyu.footwalk.data.repository.AuthRepository
import com.siyu.footwalk.data.repository.AuthRepositoryImpl
import com.siyu.footwalk.data.repository.WalkRepository
import com.siyu.footwalk.data.repository.WalkRepositoryImpl
import com.siyu.footwalk.data.session.DataStoreSessionStorage
import com.siyu.footwalk.data.session.SessionStorage
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

//único lugar que instancia Retrofit, OkHttp, la sesión y los repositorios.

class AppContainer(context: Context) {

    // Un solo lugar para cambiar la dirección de la API.
    // Emulador -> tu PC: http://10.0.2.2:3000/   |   AWS: http://IP_PUBLICA/
    private val baseUrl = "http://10.0.2.2:3000/"

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false   // no envía campos null (la API rechaza distanceKm: null)
    }

    private val sessionStorage: SessionStorage = DataStoreSessionStorage(context.applicationContext)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(sessionStorage))
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)   // BASIC: no imprime contraseñas ni tokens
        )
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val authRepository: AuthRepository =
        AuthRepositoryImpl(retrofit.create(AuthApi::class.java), sessionStorage, json)

    val walkRepository: WalkRepository =
        WalkRepositoryImpl(retrofit.create(WalkApi::class.java), sessionStorage, json)
}