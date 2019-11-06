package com.example.retrofitwithmvvm.model

import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("postId")
    val postId: Int = -1,
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("body")
    val text: String = ""
)

