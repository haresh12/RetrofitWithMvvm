package com.example.retrofitwithmvvm.retrofit

import com.example.retrofitwithmvvm.util.Constant
import com.example.retrofitwithmvvm.util.Constant.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.*


object RetrofitClient {
    var loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)
    var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
     val service: ApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        service = retrofit.create(ApiInterface::class.java)
    }


}