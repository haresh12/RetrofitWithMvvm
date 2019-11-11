package com.example.retrofitwithmvvm.retrofit

import com.example.retrofitwithmvvm.model.Comments
import com.example.retrofitwithmvvm.model.Post
import com.example.retrofitwithmvvm.model.StackOverFlowUserBadgesResponse
import com.example.retrofitwithmvvm.model.User
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*
import java.util.*
import retrofit2.http.GET




interface ApiInterface {
    @GET("users/{id}")
    fun getUser(
        @Path("id") id: Int
    ): Observable<User>

    //For without Rx java call just remove this Observable And add call
    @GET("posts")
    fun getPostsFromUser(
        @Query("userId") id: Int
    ): Observable<List<Post>>

    @GET("comments")
    fun getComments(
        @Query("id") postId: Int
    ): Observable<List<Comments>>

    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>

    //get User Badges
    @GET("users/{userId}/badges?page=1&pagesize=80&order=desc&sort=type&site=stackoverflow")
    fun getBadges(@Path("userId") userId: String): Observable<StackOverFlowUserBadgesResponse>
}