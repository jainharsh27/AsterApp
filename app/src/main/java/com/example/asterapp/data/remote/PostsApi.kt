package com.example.asterapp.data.remote

import com.example.asterapp.data.remote.dto.response.ResponseItemDto
import retrofit2.http.GET

interface PostsApi {

    @GET("/posts")
    suspend fun getPosts(): List<ResponseItemDto>

}