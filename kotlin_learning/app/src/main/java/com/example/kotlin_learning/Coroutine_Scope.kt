package com.example.kotlin_learning

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainActivity2() {
//    LaunchEffectComposable()
    CoroutineScopeComposable()
}

@Composable
fun LaunchEffectComposable() {
    val counter = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        Log.d("LaunchEffectComposable", "Started")
        try {
            for (i in 1..10) {
                counter.value++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.d("LaunchEffectComposable", "Exception - ${e.message.toString()}")
        }
    }
    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }
    Text(
        text = text, modifier = Modifier
            .size(200.dp)
            .padding(top = 40.dp)
    )
}

@Composable
fun CoroutineScopeComposable() {
    val counter = remember { mutableStateOf(0) }
    var scope = rememberCoroutineScope()

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }

    Column {
        Text(
            text = text, modifier = Modifier
                .padding(top = 40.dp)
        )
        Button(onClick = {
            scope.launch {
                Log.d("CoroutineScopeComposable", "Started")
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    Log.d("CoroutineScopeComposable", "Exception - ${e.message.toString()}")
                }
            }
        }) {
            Text(text = "Increase")

        }
    }
}