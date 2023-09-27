package com.kingsland.testapp

import com.kingsland.testapp.data.model.Item
import com.kingsland.testapp.data.model.Response
import com.kingsland.testapp.data.repository.DomainRepository
import com.kingsland.testapp.data.source.IDataSource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class RepositoryUnitTest {

    @Test
    fun `test repository`() = runTest {
        val mockDataSource = mockk<IDataSource>()

        coEvery { mockDataSource.getData() } returns Response(items = emptyList())

        val repository = DomainRepository(mockDataSource)
        val response = repository.getData()

        Assert.assertEquals(emptyList<Item>(), response.items)
    }
}