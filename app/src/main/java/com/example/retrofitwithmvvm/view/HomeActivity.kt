package com.example.retrofitwithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitwithmvvm.R
import com.example.retrofitwithmvvm.adapter.PostsRecyclerAdapter
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.model.User
import com.example.retrofitwithmvvm.util.VerticalSpacingItemDecoration
import com.example.retrofitwithmvvm.view_model.AuthViewModel
import com.example.retrofitwithmvvm.view_model.PostViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    private var adapter: PostsRecyclerAdapter? = null
    private lateinit var viewModel: PostViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter=PostsRecyclerAdapter()
        val itemDecoration = VerticalSpacingItemDecoration(15)
        recycler_view.addItemDecoration(itemDecoration)
        viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        viewModel.getUserPost(5)
            .observe(this,
                Observer<List<Post>> { userPost ->
                    adapter?.setPosts(userPost)
                    recycler_view.adapter = adapter
                })

    }

}
