package com.example.asterapp.presentation

import com.example.asterapp.common.Resource
import com.example.asterapp.domain.model.response.ResponseItem

data class PostsListState(
    val isloading: Boolean = false,
    val posts: List<ResponseItem> = emptyList(),
    val errorMsg: String = ""
)
