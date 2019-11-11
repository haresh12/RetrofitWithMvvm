package com.example.retrofitwithmvvm.rx_utils

import com.example.retrofitwithmvvm.retrofit.ApiInterface
import com.example.retrofitwithmvvm.util.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RxRetrofitClient {
    var loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)
    var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    var service: ApiInterface

    init {
        val retrofitForStackUrl = Retrofit.Builder().baseUrl(Constant.STACK_OVER_FLOW_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        service = retrofitForStackUrl.create(ApiInterface::class.java)
    }


}