package com.kingsland.testapp.data.source

import com.kingsland.testapp.data.model.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IDataSource {

    @GET(GET_DATA)
    suspend fun getData(): Response

    companion object {
        private const val GET_DATA = "b/WN0G"
        private const val BASE_URL = "https://jsonkeeper.com/"

        fun create(): IDataSource = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IDataSource::class.java)
    }
}