package com.example.kotlinflow

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


val channel = Channel<Int>()

fun producer() {
    CoroutineScope(Dispatchers.Main).launch {

        delayinChannel(1)
        delayinChannel(2)
        delayinChannel(3)


    }
}

fun consumer() {
    CoroutineScope(Dispatchers.Main).launch {
        Log.d("sumit", channel.receive().toString())
        Log.d("sumit", channel.receive().toString())
        Log.d("sumit", channel.receive().toString())
    }
}

suspend fun delayinChannel(number: Int) {
    delay(1000)
    channel.send(number)
}