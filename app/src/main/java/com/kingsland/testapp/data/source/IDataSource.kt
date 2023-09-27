package com.kingsland.testapp.data.source

import com.kingsland.testapp.data.model.Item
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

        fun getOfflineData(): List<Item> = listOf(
            Item(
                title = "RecyclerView",
                description = "The RecyclerView is a ViewGroup that renders any adapter-based view in a similar way. It is supposed to be the successor of ListView and GridView. One of the reasons is that RecyclerView has a more extensible framework, especially since it provides the ability to implement both horizontal and vertical layouts. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events.",
                date = "2022-05-18T15:15:50Z",
                img = "https://storage.googleapis.com/gweb-uniblog-publish-prod/images/Android_symbol_green_2.max-1500x1500.png"
            ),
            Item(
                capitalTitle = "Title 2",
                description = "Description 2",
                date = "2022-05-18T15:15:50Z",
                img = "https://storage.googleapis.com/gweb-uniblog-publish-prod/images/Android_symbol_green_2.max-1500x1500.png"
            ),
            Item(
                title = "Title 3",
                description = "Description 3",
                date = "2022-05-18T15:15:50Z",
                img = "https://storage.googleapis.com/gweb-uniblog-publish-prod/images/Android_symbol_green_2.max-1500x1500.png"
            ),
            Item(
                title = "Title 4",
                description = "Description 4",
                date = "2022-05-18T15:15:50Z"
            )
        )
    }
}