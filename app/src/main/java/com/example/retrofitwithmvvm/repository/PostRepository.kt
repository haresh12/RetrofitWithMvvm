package com.example.retrofitwithmvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.model.User
import com.example.retrofitwithmvvm.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository  {
    private val TAG = AuthRepository::class.java.getSimpleName()
    private var apiRequest = RetrofitClient.service
    var data = MutableLiveData<List<Post>>()

    fun getUserPost(id: Int): LiveData<List<Post>> {
        data = MutableLiveData()
        apiRequest.getPostsFromUser(id).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e(TAG, "FFFeeeild:: " + t.message)
            }
        })
        return data
    }

}