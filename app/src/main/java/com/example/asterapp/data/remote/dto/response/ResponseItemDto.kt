package com.example.asterapp.data.remote.dto.response

import com.example.asterapp.domain.model.response.ResponseItem

data class ResponseItemDto (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun ResponseItemDto.toResponseItem(): ResponseItem {
    return ResponseItem(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}

