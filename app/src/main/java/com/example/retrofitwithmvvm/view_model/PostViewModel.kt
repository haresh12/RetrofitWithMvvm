package com.example.retrofitwithmvvm.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.model.User
import com.example.retrofitwithmvvm.repository.AuthRepository
import com.example.retrofitwithmvvm.repository.PostRepository

class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PostRepository = PostRepository()
    private var userId: Int = -1
    lateinit var userPost: LiveData<List<Post>>

    fun getUserPost(id: Int): LiveData<List<Post>> {
        this.userId = id
        userPost = repository.getUserPost(id)
        return userPost
    }
}