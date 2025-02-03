package com.example.kotlin_learning

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay


@Composable
fun Counters() {
//    val state = remember { mutableStateOf(0) }
//    LaunchedEffect(key1 = Unit) {
//        for (i in 1..10) {
//            delay(1000)
//            state.value++
//        }
//    }
    // instead of writing remember and mutableStateOf we can use produceState
    val state = produceState(initialValue = 0) {
        for (i in 1..10) {
            delay(1000)
            value += 10
        }
    }


    Text(
        text = state.value.toString(),
        style = MaterialTheme.typography.headlineLarge
    )
}