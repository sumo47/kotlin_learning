package com.example.kotlinflow

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

fun FlowOperators() {
    GlobalScope.launch {
        val producer: Flow<Int> = producerFlow3()
        // flow operators
//        producer
//            // when consumer start to emmit , it will start to collect
//            .onStart {
//                emit(-1) // we can emit manually
//                Log.d("sumit", "onStart: Started") }
//
//            // after collect all emit
//            .onCompletion {
//                emit(11) // we can emit manually
//                Log.d("sumit", "onCompletion: Completed") }
//
//            // before collect each emit
//            .onEach { Log.d("sumit", "onEach: $it") }
//
//            .collect { Log.d("sumit", "consumerFlow: $it") }
        // terminal operators - collect , first , toList
//        val data = producer.first()
//        val data = producer.toList() // gives all collected data into list
//        Log.d("sumit", "consumerFlow: $data")

        // Non Terminal operator
        val data = producer
            .map { it * 2 }
            .filter { it < 8 }
            .collect{Log.d("sumit", "consumerFlow: $it")}
        // for start operation , we need terminal operator

    }

}

fun producerFlow3() = flow {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    list.forEach {
        delay(1000)
        emit(it)
    }
}

