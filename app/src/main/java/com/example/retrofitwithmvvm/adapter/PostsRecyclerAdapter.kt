package com.example.retrofitwithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithmvvm.R
import com.example.retrofitwithmvvm.databinding.LayoutPostListItemBinding
import com.example.retrofitwithmvvm.model.Post
import kotlinx.android.synthetic.main.layout_post_list_item.view.*
import java.util.ArrayList

class PostsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var posts: List<Post> = ArrayList<Post>()
    private lateinit var binding: LayoutPostListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflater: LayoutInflater? = null
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        binding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.layout_post_list_item, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView: LayoutPostListItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        fun bind(post: Post) {
            binding.post = post
        }
    }
}