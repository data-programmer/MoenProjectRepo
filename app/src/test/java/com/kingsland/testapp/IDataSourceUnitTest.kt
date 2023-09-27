package com.kingsland.testapp

import com.kingsland.testapp.data.model.Item
import com.kingsland.testapp.data.model.Response
import com.kingsland.testapp.data.source.IDataSource
import io.mockk.coEvery
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class IDataSourceUnitTest {

    @Test
    fun `test data source`() = runTest {
        val dataSource = IDataSource.create()

        coEvery { dataSource.getData() } returns Response(items = emptyList())

        val response = dataSource.getData()

        Assert.assertEquals(emptyList<Item>(), response.items)
    }
}