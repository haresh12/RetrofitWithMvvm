package com.example.retrofitwithmvvm.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.model.User
import com.example.retrofitwithmvvm.retrofit.RetrofitClient
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {
    private val TAG = AuthRepository::class.java.getSimpleName()
    private var apiRequest = RetrofitClient.service
    var data = MutableLiveData<List<Post>>()


    // with simple retrofit call we are retriving the data
//    fun getUserPost(id: Int): LiveData<List<Post>> {
//        data = MutableLiveData()
//        apiRequest.getPostsFromUser(id).enqueue(object : Callback<List<Post>> {
//            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//                if (response.isSuccessful) {
//                    data.value = response.body()
//                }
//            }
//            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                Log.e(TAG, "FFFeeeild:: " + t.message)
//            }
//        })
//        return data
//    }


    // call retrofit with rx java
    fun getUserPost(id: Int): LiveData<List<Post>> {
        data = MutableLiveData()
        val observeCommentList = apiRequest.getPostsFromUser(id)
        observeCommentList
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Post>> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(postList: List<Post>) {
                    data.value = postList
                }

                override fun onError(e: Throwable) {
                }
            })
        return data
    }


}