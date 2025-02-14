package com.example.kotlinflow

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
import com.example.kotlinflow.ui.theme.KotlinFlowTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // coroutine
//        CoroutineScope(Dispatchers.IO).launch {
//            getUserNames().forEach {
//                Log.d("sumit", it)
//            }
//        }

        // Channel----
//        producer()
//        consumer()
        setContent {
            Text(text = "haha")
        }
        // Flow-----
//       job
//        Consumers()
//        FlowOperators()

        //Flow Operation Example ----
//        CoroutineScope(Dispatchers.Main).launch {
//            getNotes()
//                .map { FormattedNote(it.isActive, it.title, it.description) }
//                .filter { it.isActive }
//                .collect { Log.d("sumit", it.toString()) }
//        }

        // Buffer ----
        buffer()


    }
}

