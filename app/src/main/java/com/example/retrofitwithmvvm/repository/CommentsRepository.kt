package com.example.retrofitwithmvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.model.Comments
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsRepository {
    private val TAG = AuthRepository::class.java.getSimpleName()
    private var apiRequest = RetrofitClient.service
    var data = MutableLiveData<List<Comments>>()

    fun getPostComments(id: Int): LiveData<List<Comments>> {
        data = MutableLiveData()
        apiRequest.getComments(id).enqueue(object : Callback<List<Comments>> {
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.e(TAG, "FFFeeeild:: " + t.message)
            }
        })
        return data
    }
}