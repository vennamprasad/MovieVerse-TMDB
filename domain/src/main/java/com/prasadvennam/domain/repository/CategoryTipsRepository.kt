package com.prasadvennam.domain.repository

interface CategoryTipsRepository {
    suspend fun showCategoryDetailsTip(): Boolean
    suspend fun closeCategoryDetailsTip()
}