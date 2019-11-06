package com.example.retrofitwithmvvm.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.repository.PostRepository
import com.example.retrofitwithmvvm.repository.SendPostRepository

class SendPostViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SendPostRepository = SendPostRepository()
    private var Post: Post? = null
    lateinit var userPost: LiveData<Post>



    fun createPost(post: Post): LiveData<Post> {
        this.Post = post
        userPost = repository.createPost(post)
        return userPost
    }
}