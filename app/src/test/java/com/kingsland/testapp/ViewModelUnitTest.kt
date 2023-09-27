package com.kingsland.testapp

import com.kingsland.testapp.data.model.Item
import com.kingsland.testapp.data.model.Response
import com.kingsland.testapp.domain.usecase.GetDataUseCase
import com.kingsland.testapp.presentation.main.model.DataState
import com.kingsland.testapp.presentation.main.viewmodel.DataViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class ViewModelUnitTest {

    private lateinit var mockUseCase: GetDataUseCase

    @Before
    fun before() {
        mockUseCase = mockk()
    }

    @Test
    fun `test getData()`() = runTest {
        coEvery { mockUseCase.getData() } returns Response(items = emptyList())

        val viewModel = DataViewModel(mockUseCase)
        val response = (viewModel.dataState as DataState.Loaded).data

        Assert.assertEquals(emptyList<Item>(), response)
    }

    @Test
    fun `test viewModel loaded state`() = runTest {
        coEvery { mockUseCase.getData() } returns Response(items = emptyList())

        val viewModel = DataViewModel(mockUseCase)

        Assert.assertEquals(DataState.Loaded(emptyList()), viewModel.dataState)
    }

    @Test
    fun `test viewModel error state`() = runTest {
        val message = "There was an IO error."
        coEvery { mockUseCase.getData() } throws IOException(message)

        val viewModel = DataViewModel(mockUseCase)

        Assert.assertEquals(DataState.Error(message), viewModel.dataState)
    }

}