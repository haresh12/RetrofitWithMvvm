package com.example.retrofitwithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.retrofitwithmvvm.model.Comments
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.view_model.CommentsViewModel
import com.example.retrofitwithmvvm.view_model.SendPostViewModel
import kotlinx.android.synthetic.main.activity_comments.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.lifecycle.ViewModelProvider


class CommentsActivity : AppCompatActivity() {
    private lateinit var viewModel: CommentsViewModel
    private lateinit var sendPostViewModel: SendPostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.retrofitwithmvvm.R.layout.activity_comments)

        viewModel = ViewModelProvider(
            this
        ).get(CommentsViewModel::class.java)

//        sendPostViewModel = ViewModelProvider(
//            this
//        ).get(SendPostViewModel::class.java)
//        val fakePost = Post(userId = "5", title = "haresh", body = "this is haresh")
//        sendPostViewModel.createPost(fakePost).observe(this,
//            Observer<Post> { post ->
//                var content = ""
//                post.apply {
//                    content += "ID: $id\n"
//                    content += "User ID: $userId\n"
//                    content += "Title: $title\n"
//                    content += "Text: $body\n"
//                }
//                text_view_result.text = content
//            })


        viewModel.getPostComments(1).observe(this, object : Observer<List<Comments>> {
            override fun onChanged(commentsList: List<Comments>?) {
                commentsList?.forEach {
                    it.apply {
                        var content = ""
                        content += "ID: $id\n"
                        content += "Post ID: $postId\n"
                        content += "Name: $name\n"
                        content += "Email: $email\n"
                                content += "Text: $text\n\n"
                        text_view_result.append(content)

                    }

                }
            }

        })


    }
}
