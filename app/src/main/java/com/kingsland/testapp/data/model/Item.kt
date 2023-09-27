package com.kingsland.testapp.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("Title")
    val capitalTitle: String? = null,
    val date: String? = null,
    val img: String? = null,
    val title: String? = null,
    val description: String,
)