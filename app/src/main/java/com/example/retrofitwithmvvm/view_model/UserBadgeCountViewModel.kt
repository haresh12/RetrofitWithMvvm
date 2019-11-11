package com.example.retrofitwithmvvm.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.retrofitwithmvvm.model.Comments
import com.example.retrofitwithmvvm.model.StackOverFlowUserBadgesResponse
import com.example.retrofitwithmvvm.repository.UserBadgeCountRepo

class UserBadgeCountViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserBadgeCountRepo = UserBadgeCountRepo()
    private var userId: String = "0"
    lateinit var userBadgeData: LiveData<StackOverFlowUserBadgesResponse>

    fun getUserBadgeDetails(userId: String): LiveData<StackOverFlowUserBadgesResponse> {
        this.userId = userId
        userBadgeData = repository.getUserBadgeDetails(userId)
        return userBadgeData
    }
}