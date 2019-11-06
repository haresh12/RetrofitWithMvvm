package com.example.retrofitwithmvvm.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.retrofitwithmvvm.model.Comments
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.repository.CommentsRepository
import com.example.retrofitwithmvvm.repository.PostRepository

class CommentsViewModel(application: Application):AndroidViewModel(application){
    private val repository: CommentsRepository = CommentsRepository()
    private var postId: Int = -1
    lateinit var userPost: LiveData<List<Comments>>

    fun getPostComments(id: Int): LiveData<List<Comments>> {
        this.postId = id
        userPost = repository.getPostComments(id)
        return userPost
    }
}