package com.siyu.footwalk.data.remote

import com.siyu.footwalk.data.remote.dto.ErrorDto
import com.siyu.footwalk.model.AppException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

//Traducción de errores de red
internal suspend fun <T> safeApiCall(json: Json, block: suspend () -> T): T =
    try {
        block()
    } catch (e: CancellationException) {
        throw e
    } catch (e: HttpException) {
        throw e.toAppException(json)
    } catch (e: IOException) {
        throw AppException("No se pudo conectar con el servidor. Revisa tu conexión.")
    } catch (e: SerializationException) {
        throw AppException("Respuesta inesperada del servidor.")
    }

private fun HttpException.toAppException(json: Json): AppException {
    val body = runCatching { response()?.errorBody()?.string() }.getOrNull()
    val dto = body?.let { runCatching { json.decodeFromString<ErrorDto>(it) }.getOrNull() }
    val message = dto?.details?.firstOrNull()?.message
        ?: dto?.error?.takeIf { it.isNotBlank() }
        ?: "Error del servidor (${code()})"
    return AppException(message, code())
}