package com.example.asterapp.domain.repository

import com.example.asterapp.common.Resource
import com.example.asterapp.data.remote.dto.response.ResponseItemDto
import com.example.asterapp.domain.model.response.ResponseItem
import kotlinx.coroutines.flow.Flow


interface PostsRepository {

    fun getPosts(): Flow<Resource<List<ResponseItem>>>
}