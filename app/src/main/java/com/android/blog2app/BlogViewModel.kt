package com.android.blog2app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BlogViewModel : ViewModel() {
    private val _blogPosts = MutableLiveData<List<BlogPost>>()
    val blogPosts: LiveData<List<BlogPost>> = _blogPosts

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private var currentPage = 1

    fun loadBlogPosts() {
        _loading.value = true
        _error.value = null
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getBlogPosts(10, currentPage)
                if (response.isNotEmpty()) {
                    _blogPosts.value = _blogPosts.value.orEmpty() + response
                    currentPage++
                }
                _loading.value = false
            } catch (e: Exception) {
                _blogPosts.value = emptyList()
                _loading.value = false
                _error.value = e.message
            }
        }
    }
}