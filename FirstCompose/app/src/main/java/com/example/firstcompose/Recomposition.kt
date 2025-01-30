package com.example.firstcompose

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun recompositon(){
    Recomposable()
}

@Composable
fun Recomposable(){
    val state = remember { mutableStateOf(0.0) }
    Log.d("TAGGED", "Logged during Initial Composition")
    Button(onClick = {
        state.value = Math.random()
    }) {
        Log.d("TAGGED", "Logged during both Composition & Recomposition")
        Text(text= state.value.toString())
    }
}