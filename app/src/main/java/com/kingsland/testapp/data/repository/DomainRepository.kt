package com.kingsland.testapp.data.repository

import com.kingsland.testapp.data.model.Response
import com.kingsland.testapp.data.source.IDataSource
import com.kingsland.testapp.domain.repository.IDomainRepository
import javax.inject.Inject

class DomainRepository @Inject constructor(
    private val dataSource: IDataSource
): IDomainRepository {
    override suspend fun getData(): Response = dataSource.getData()
    override suspend fun getOfflineData(): Response = Response(IDataSource.getOfflineData())
}