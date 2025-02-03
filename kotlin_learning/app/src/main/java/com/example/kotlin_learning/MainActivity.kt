package com.example.kotlin_learning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_learning.ui.theme.Kotlin_learningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            App()
//            MainActivity2()
//            RememberUpdatedState()
            RememberUpdatedState2()
        }
    }
}

@Composable
fun App() {
    var count = rememberSaveable() { mutableStateOf(0) }
    var value = remember { mutableStateOf(0) }

    if (count.value % 3 == 0) {
        value.value = count.value
    }
    LaunchedEffect(key1 = value.value) {
        Log.d("Count", "Current Count - ${count.value}")
    }
    Column(modifier = Modifier.padding(top = 30.dp)) {
        Button(
            onClick = {
                count.value++
            }
        ) {
            Text(text = "Increase")
        }

        Text(text = "Current count - ${count.value}")

    }
}