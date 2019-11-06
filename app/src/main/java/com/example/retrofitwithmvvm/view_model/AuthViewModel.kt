package com.example.retrofitwithmvvm.view_model

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.retrofitwithmvvm.model.User
import com.example.retrofitwithmvvm.repository.AuthRepository
import com.example.retrofitwithmvvm.retrofit.AuthResource
import com.example.retrofitwithmvvm.view.AuthActivity

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AuthRepository = AuthRepository()
    private var userId: Int = -1
    lateinit var userData: LiveData<User>
    fun getAuthUserDetails(id: Int): LiveData<User> {
        this.userId = id
        userData = repository.getUserDetails(id)
        return userData
    }


}