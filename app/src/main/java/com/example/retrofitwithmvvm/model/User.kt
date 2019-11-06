package com.example.retrofitwithmvvm.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: Int = -1,
    @SerializedName("username") val username: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("website") val website: String = "",
    @SerializedName("progress") var progress: Boolean = true


)