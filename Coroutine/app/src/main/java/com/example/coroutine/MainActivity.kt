package com.example.coroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text(text = "Hello World!")
        }
        CoroutineScope(Dispatchers.Main).launch {
            executeTask()

        }
    }

    private suspend fun executeTask() {
        Log.d("sumit", "Before")
//        GlobalScope.launch { // let use withContext
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d("sumit", "Inside")

        }
        Log.d("sumit", "After")
    }

}

//output -

//Before
//Inside
//After




