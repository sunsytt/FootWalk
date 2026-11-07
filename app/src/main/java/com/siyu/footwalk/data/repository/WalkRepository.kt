package com.siyu.footwalk.data.repository

import com.siyu.footwalk.model.Walk
import com.siyu.footwalk.model.WalkInput
import com.siyu.footwalk.model.WalksOverview

interface WalkRepository {
    suspend fun getOverview(): WalksOverview
    suspend fun getWalk(id: Int): Walk
    suspend fun createWalk(input: WalkInput): Walk
    suspend fun updateWalk(id: Int, input: WalkInput): Walk
    suspend fun deleteWalk(id: Int)
}