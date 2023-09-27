package com.kingsland.testapp.domain.usecase

import com.kingsland.testapp.data.model.Response
import com.kingsland.testapp.domain.repository.IDomainRepository
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val domainRepository: IDomainRepository
) {
    suspend fun getData(): Response = domainRepository.getData()
}