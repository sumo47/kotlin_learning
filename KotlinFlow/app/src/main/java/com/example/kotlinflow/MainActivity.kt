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

        GlobalScope.launch(Dispatchers.Main) {
            val result = producer()
            result
                .collect { Log.d("sumit", "Consumer1 : $it") }
        }

        GlobalScope.launch(Dispatchers.Main) {
            val result = producer()
            delay(2500)
            result
                .collect { Log.d("sumit", "Consumer2: $it") }
        }
    }
}

// sharedFlow is Hot type of flow
private fun producer(): Flow<Int> {
    val mutableSharedFlow = MutableSharedFlow<Int>(replay = 2) // replay = 2 means late consumer will get previous 2 data form that point, if consumer will start to collect from 4 then they will get from 2
    GlobalScope.launch {
        val list = listOf(1, 2, 3, 4, 5)
        list.forEach {
            mutableSharedFlow.emit(it)
            delay(1000)
        }

    }
    return mutableSharedFlow

}

// now if any consumer will take delay to collect emitted data , than they will lost previous data