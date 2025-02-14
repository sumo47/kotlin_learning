package com.example.kotlinflow

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


// . GlobalScope mein launch kiye gaye coroutines ko top-level coroutines mana jata hai.
val job = GlobalScope.launch {
    val data: Flow<Int> = producerFlow()
    data.collect {
        Log.d("sumit", "consumerFlow: $it")
    }
}

val cancelJob = GlobalScope.launch {
    delay(3500)
    job.cancel()
    Log.d("sumit", "cancelJob: Cancelled")
}

fun producerFlow() = flow {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    list.forEach {
        delay(1000)
        emit(it)
    }
}