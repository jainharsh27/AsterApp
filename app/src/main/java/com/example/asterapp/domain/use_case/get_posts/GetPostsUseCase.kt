package com.example.asterapp.domain.use_case.get_posts

import com.example.asterapp.domain.repository.PostsRepository

class GetPostsUseCase(
    private val repository: PostsRepository
) {
    operator fun invoke() = repository.getPosts()
}
