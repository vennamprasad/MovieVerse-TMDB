package com.prasadvennam.domain.repository

interface HistoryTipsRepository {
    suspend fun showHistoryTip(): Boolean
    suspend fun closeHistoryTip()
}