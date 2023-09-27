package com.kingsland.testapp.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("Title")
    val capitalTitle: String?,
    val date: String?,
    val description: String,
    val img: String?,
    val title: String
)