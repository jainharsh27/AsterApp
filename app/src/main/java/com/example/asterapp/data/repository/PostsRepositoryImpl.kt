package com.example.asterapp.data.repository

import com.example.asterapp.common.Resource
import com.example.asterapp.data.remote.PostsApi
import com.example.asterapp.data.remote.RetrofitInstance
import com.example.asterapp.data.remote.dto.response.toResponseItem
import com.example.asterapp.domain.model.response.ResponseItem
import com.example.asterapp.domain.repository.PostsRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class PostsRepositoryImpl() : PostsRepository {
    private val apiService: PostsApi = RetrofitInstance.apiService
    override fun getPosts() = flow {
        try {
            emit(Resource.Loading<List<ResponseItem>>())
            val posts = apiService.getPosts().map { it.toResponseItem() }
            emit(Resource.Success<List<ResponseItem>>(posts))
        } catch(e: HttpException) {
            emit(Resource.Error<List<ResponseItem>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<ResponseItem>>("Couldn't reach server. Check your internet connection."))
        }
    }


}