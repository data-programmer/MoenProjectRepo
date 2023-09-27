package com.kingsland.testapp.domain.usecase

import com.kingsland.testapp.data.model.Response
import com.kingsland.testapp.data.repository.DomainRepository
import javax.inject.Inject

class GetOfflineDataUseCase @Inject constructor(
    private val  domainRepository: DomainRepository
) {
    suspend fun getOfflineData(): Response = domainRepository.getOfflineData()
}