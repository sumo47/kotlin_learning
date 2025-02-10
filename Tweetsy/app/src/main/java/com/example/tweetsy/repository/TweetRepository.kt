package com.example.tweetsy.repository

import android.util.Log
import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets


//    suspend fun getCategories() {
//        val response = tweetsyAPI.getCategories()
//        if (response.isSuccessful && response.body() != null) {
//            _categories.emit(response.body()!!)
//        }
//    }

    suspend fun getCategories() {
        try {
            val response = tweetsyAPI.getCategories()
            if (response.isSuccessful && response.body() != null) {
                Log.d("TweetRepository", "Categories fetched: ${response.body()!!}")
                _categories.emit(response.body()!!)
            } else {
                Log.e(
                    "TweetRepository",
                    "Failed to fetch categories: ${response.code()} - ${response.message()}"
                )
            }
        } catch (e: Exception) {
            Log.e("TweetRepository", "Exception: ${e.message}")
        }
    }


    suspend fun getTweets(category: String) {
        val response = tweetsyAPI.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}
