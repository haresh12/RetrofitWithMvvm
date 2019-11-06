package com.example.retrofitwithmvvm.retrofit

import com.example.retrofitwithmvvm.model.Comments
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.model.User
import retrofit2.Call
 import retrofit2.http.*


interface ApiInterface {
    @GET("users/{id}")
    fun getUser(
        @Path("id") id: Int
    ): Call<User>

    @GET("posts")
    fun getPostsFromUser(
        @Query("userId") id: Int
    ): Call<List<Post>>

    @GET("comments")
    fun getComments(
        @Query("id") postId: Int
    ): Call<List<Comments>>

    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>
}