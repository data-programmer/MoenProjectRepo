package com.kingsland.testapp

import com.kingsland.testapp.data.model.Item
import com.kingsland.testapp.data.model.Response
import com.kingsland.testapp.domain.repository.IDomainRepository
import com.kingsland.testapp.domain.usecase.GetDataUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class UseCaseUnitTest {

    @Test
    fun `test usecase getData()`() = runTest {
        val mockRepository = mockk<IDomainRepository>()

        coEvery { mockRepository.getData() } returns Response(items = emptyList())

        val useCase = GetDataUseCase(mockRepository)
        val response = useCase.getData()

        Assert.assertEquals(emptyList<Item>(), response.items)
    }

}