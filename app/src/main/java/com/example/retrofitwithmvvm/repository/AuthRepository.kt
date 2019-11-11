package com.example.retrofitwithmvvm.repository

import android.util.Log
import android.view.View
import android.widget.AbsSeekBar
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.model.User
import com.example.retrofitwithmvvm.retrofit.RetrofitClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    private val TAG = AuthRepository::class.java.simpleName
    private var apiRequest = RetrofitClient.service
    var data = MutableLiveData<User>()


    //Simple Retrofit call
//    fun getUserDetails(id: Int): LiveData<User> {
//        data = MutableLiveData()
//        apiRequest.getUser(id).enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                if (response.isSuccessful) {
//                    data.value = response.body()
//                }
//            }
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                Log.e(TAG, "FFFeeeild:: " + t.message)
//            }
//        })
//        return data
//    }


    // Retrofit call with Rx java

    fun getUserDetails(id: Int): LiveData<User> {
        data = MutableLiveData()
        apiRequest.getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<User> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(userData: User) {
                    data.value = userData
                }

                override fun onError(e: Throwable) {
                }
            })

        return data
    }


}