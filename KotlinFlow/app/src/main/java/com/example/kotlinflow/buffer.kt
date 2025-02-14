package com.example.kotlinflow

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis


fun buffer() {
    GlobalScope.launch {
        val time = measureTimeMillis { // use to measure time
            provider4()
                .buffer(3) // use to buffer data
                .collect {
                delay(1500)
                Log.d("sumit", "consumerFlow: $it")
            }
        }
        Log.d("sumit", "time: $time")
    }
}

fun provider4(): Flow<Int> {
    return flow<Int> {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        list.forEach {
            delay(1000)
            emit(it)
        }
    }
}