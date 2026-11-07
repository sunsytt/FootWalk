package com.siyu.footwalk.data.repository

import com.siyu.footwalk.data.mapper.toDto
import com.siyu.footwalk.data.mapper.toModel
import com.siyu.footwalk.data.remote.api.WalkApi
import com.siyu.footwalk.data.remote.safeApiCall
import com.siyu.footwalk.data.session.SessionStorage
import com.siyu.footwalk.model.AppException
import com.siyu.footwalk.model.SessionExpiredException
import com.siyu.footwalk.model.Walk
import com.siyu.footwalk.model.WalkInput
import com.siyu.footwalk.model.WalksOverview
import kotlinx.serialization.json.Json

class WalkRepositoryImpl(
    private val api: WalkApi,
    private val sessionStorage: SessionStorage,
    private val json: Json,
) : WalkRepository {

    private suspend fun <T> call(block: suspend () -> T): T =
        try {
            safeApiCall(json, block)
        } catch (e: AppException) {
            if (e.code == 401) {
                sessionStorage.clear()
                throw SessionExpiredException()
            }
            throw e
        }

    override suspend fun getOverview(): WalksOverview = call { api.getWalks().toModel() }

    override suspend fun getWalk(id: Int): Walk = call { api.getWalk(id).toModel() }

    override suspend fun createWalk(input: WalkInput): Walk = call { api.createWalk(input.toDto()).toModel() }

    override suspend fun updateWalk(id: Int, input: WalkInput): Walk =
        call { api.updateWalk(id, input.toDto()).toModel() }

    override suspend fun deleteWalk(id: Int) = call { api.deleteWalk(id) }
}