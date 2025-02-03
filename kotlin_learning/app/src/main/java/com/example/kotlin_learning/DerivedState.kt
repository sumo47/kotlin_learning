package com.example.kotlin_learning

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun Derived(){
    val tableOf = remember { mutableStateOf(5) }
    val index = produceState(initialValue = 1) {
        repeat(9){
            delay(1000)
            value += 1
        }
    }

    val message = derivedStateOf {
        "${tableOf.value} * ${index.value} = ${tableOf.value * index.value}"
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
    ){
        Text(text = message.value, style = MaterialTheme.typography.headlineLarge)

    }
}