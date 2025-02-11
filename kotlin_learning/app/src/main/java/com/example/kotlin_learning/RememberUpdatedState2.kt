package com.example.kotlin_learning

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay


fun a() { Log.d("RememberUpdatedState2", "I am A from app") }

fun b() { Log.d("RememberUpdatedState2", "I am B from app") }

@Composable
fun RememberUpdatedState2() {
    Log.d("RememberUpdatedState2", "started...")
    val state = remember { mutableStateOf(::a) }
    Button(
        onClick = {
            state.value = ::b;
            Log.d("RememberUpdatedState2", "Clicked")
        }) {
        Text(text = "Click to Change state")
    }
    LandingScreen(state.value)
}
// whenever clicked state changes and recomposition happens

@Composable
fun LandingScreen(onTimeout: () -> Unit) {
    val currentOnTimeout =
        rememberUpdatedState(onTimeout) // rememberUpdatedState return state object
    LaunchedEffect(true) {
        delay(5000)
        currentOnTimeout.value() // state.value
    }
}