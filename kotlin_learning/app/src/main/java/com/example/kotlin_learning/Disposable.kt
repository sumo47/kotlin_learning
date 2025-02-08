package com.example.kotlin_learning

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun DisposableFunction (){
    var state = remember { mutableStateOf(false) }

    Button(
        onClick = {
            state.value = !state.value
        }
    ) {
        Text(text = "Click")

    }

    DisposableEffect(key1 = state.value) { // it runs once when recomposition
        Log.d("disposableFunction", "Started")
        onDispose { // it runs when key1 change
            Log.d("disposableFunction", "Cleaning .. Disposed")
        }
    }
}