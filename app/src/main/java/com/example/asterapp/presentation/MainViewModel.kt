package com.example.asterapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asterapp.common.Resource
import com.example.asterapp.data.repository.PostsRepositoryImpl
import com.example.asterapp.domain.use_case.get_posts.GetPostsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel : ViewModel() {

    private val _state = mutableStateOf(PostsListState())
    val state: State<PostsListState> = _state

    private val getRepositoryImpl = PostsRepositoryImpl()
    private val getPostsUseCase = GetPostsUseCase(getRepositoryImpl)

    fun getPosts() {
        getPostsUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = PostsListState(
                        errorMsg = result.message ?: "Something went wrong."
                    )
                }
                is Resource.Loading -> {
                    _state.value = PostsListState(
                        isloading = true
                    )
                }
                is Resource.Success -> {
                    _state.value = PostsListState(
                        posts = result.data ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)



    }

}

