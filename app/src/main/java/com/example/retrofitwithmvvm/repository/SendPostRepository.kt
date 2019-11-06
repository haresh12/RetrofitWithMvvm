package com.example.retrofitwithmvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SendPostRepository {
    private val TAG = AuthRepository::class.java.getSimpleName()
    private var apiRequest = RetrofitClient.service
    var data = MutableLiveData<Post>()

    fun createPost(post: Post): LiveData<Post> {
        data = MutableLiveData()
        apiRequest.createPost(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.e(TAG, "FFFeeeild:: " + t.message)
            }
        })
        return data
    }
}