package com.kingsland.testapp.domain.repository

import com.kingsland.testapp.data.model.Response

interface IDomainRepository {
    suspend fun getData(): Response
    suspend fun getOfflineData(): Response
}