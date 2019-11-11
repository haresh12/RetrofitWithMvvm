package com.example.retrofitwithmvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.model.StackOverFlowUserBadgesResponse
import com.example.retrofitwithmvvm.rx_utils.RxAPICallHelper
import com.example.retrofitwithmvvm.rx_utils.RxAPICallback
import com.example.retrofitwithmvvm.rx_utils.RxRetrofitClient
import io.reactivex.disposables.Disposable

class UserBadgeCountRepo {
    private val TAG = UserBadgeCountRepo::class.java.getSimpleName()
    private var apiRequest = RxRetrofitClient.service
    var data = MutableLiveData<StackOverFlowUserBadgesResponse>()
    private var disposable: Disposable? = null


    fun getUserBadgeDetails(id: String): LiveData<StackOverFlowUserBadgesResponse> {
        data = MutableLiveData()
        val observeStackUserBadge = apiRequest.getBadges(id)
        disposable = RxAPICallHelper.call(observeStackUserBadge,
            object : RxAPICallback<StackOverFlowUserBadgesResponse> {
                override fun onSuccess(badgesResponse: StackOverFlowUserBadgesResponse) {
                    if (badgesResponse.getItems()!!.isNotEmpty()) {
                        data.value = badgesResponse
                    }
                    disposeCall()
                }
                override fun onFailed(throwable: Throwable) {
                    Log.e(TAG, throwable.message.toString())
                }

            })

        return data
    }

    private fun disposeCall() {
        if (disposable != null && !disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }

}