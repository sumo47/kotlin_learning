package com.example.tweetsy.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetRepository) : ViewModel() {

    val categories: StateFlow<List<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            try {
                repository.getCategories()
                Log.d("CategoryViewModel", "Categories fetched: ${repository.categories.value}")
            } catch (e: Exception) {
                Log.e("CategoryViewModel", "Error fetching categories: ${e.message}")
            }
        }
    }
}