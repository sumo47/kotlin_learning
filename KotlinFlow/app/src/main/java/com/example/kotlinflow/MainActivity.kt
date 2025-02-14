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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { Text(text = "haha") }

//        GlobalScope.launch(Dispatchers.Main) {
//            val result = producer()
//            delay(6000)
//            result
//                .collect { Log.d("sumit", "Consumer1 : $it") }
//        }
        GlobalScope.launch(Dispatchers.Main) {
            val result = producer()
            Log.d("sumit", "value : ${result.value}")
        }
    }

    // stateFlow is also hot nature
// it store last value , whenever consumer will access data it will return last value
//private fun producer(): Flow<Int> {
    private fun producer(): StateFlow<Int> { // if we return stateFlow , than any consumer can check the value of stateFlow , in this case it is 10
        val mutableStateFlow = MutableStateFlow(10)
        GlobalScope.launch {
            delay(2000)
            mutableStateFlow.emit(20)
            delay(2000)
            mutableStateFlow.emit(30)
        }
        return mutableStateFlow

    }
}
