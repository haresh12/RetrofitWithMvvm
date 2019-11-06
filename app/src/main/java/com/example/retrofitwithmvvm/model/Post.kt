package com.example.retrofitwithmvvm.model

import androidx.databinding.ObservableField
import com.google.gson.annotations.SerializedName
import java.util.*

data class Post(
    @SerializedName("userId") val userId: String = "",
    @SerializedName("id") val id: String = "",
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String = ""
)