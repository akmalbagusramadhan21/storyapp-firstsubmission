package com.example.storyapp.api

import com.example.storyapp.data.response.AddNewStoryResponse
import com.example.storyapp.data.response.DetailStoryResponse
import com.example.storyapp.data.response.LoginResponse
import com.example.storyapp.data.response.RegisterResponse
import com.example.storyapp.data.response.StoriesResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun logInUser(
        @Field("email") email: String,
        @Field("password") password: String,
    ): LoginResponse


    @GET("stories")
    suspend fun getStories(   @Header("Authorization") token: String,): StoriesResponse


    @GET("stories/{id}")
    suspend fun getDetailStory(   @Header("Authorization") token: String,@Path("id") id: String): DetailStoryResponse

    @Multipart
    @POST("stories")
    suspend fun addStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): AddNewStoryResponse

}