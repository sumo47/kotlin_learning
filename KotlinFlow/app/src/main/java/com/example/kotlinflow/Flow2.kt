package com.example.kotlinflow

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

fun Consumers(){
     GlobalScope.launch {
        val data: Flow<Int> = producerFlow2()
        data.collect {
            Log.d("sumit", "FirstConsumerFlow: $it")
        }
    }
    GlobalScope.launch {
        val data: Flow<Int> = producerFlow2()
        delay(2500) // even second consumer is slow than first consumer but it will get data from starting of producer
        data.collect {
            Log.d("sumit", "SecondConsumerFlow: $it")
        }
    }
}

fun producerFlow2() = flow {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    list.forEach {
        delay(1000)
        emit(it)
    }
}