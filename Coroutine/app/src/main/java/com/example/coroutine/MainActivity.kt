package com.example.coroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coroutine.ui.theme.CoroutineTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
        doAction()
    }

}

fun doAction() {
    CoroutineScope(Dispatchers.Main).launch {
        Log.d("sumit", "1 - ${Thread.currentThread()}")
    }
    CoroutineScope(Dispatchers.IO).launch {
        Log.d("sumit", "2 - ${Thread.currentThread()}")
    }
    CoroutineScope(Dispatchers.Default).launch {
        Log.d("sumit", "3 - ${Thread.currentThread()}")
    }

}