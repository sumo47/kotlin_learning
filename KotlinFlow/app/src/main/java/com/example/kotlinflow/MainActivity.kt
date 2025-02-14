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
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent { Text(text = "haha") }
//        GlobalScope.launch(Dispatchers.Main) {
//            producer()
//                .collect {
//                    Log.d("sumit", "Consumer Thread: ${Thread.currentThread().name}")
//                }
//        }
//    }
//}
//
//private fun producer(): Flow<Int> {
//    return flow {
//        withContext(Dispatchers.IO) {
//            val list = listOf(1, 2, 3, 4, 5)
//            list.forEach {
//                delay(1000)
//                Log.d("sumit", "Emitter Thread: ${Thread.currentThread().name}")
//                emit(it)
//            }
//        }
//
//    }
//}


// here producer is executing on IO thread but consumer is executing on main thread
// it gives error
// we can fix using flowOn operator
// here we tells flow to execute on IO thread and consumer on main thread
//--------------------------------------------------------------------------------------------------------------
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent { Text(text = "haha") }
//        GlobalScope.launch(Dispatchers.Main) {
//            producer()
//                .flowOn(Dispatchers.IO) // now producer is executing on IO thread
//                .collect {
//                    Log.d("sumit", "Consumer Thread: ${Thread.currentThread().name}")
//                }
//        }
//    }
//}
//
//private fun producer(): Flow<Int> {
//    return flow {
//
//        val list = listOf(1, 2, 3, 4, 5)
//        list.forEach {
//            delay(1000)
//            Log.d("sumit", "Emitter Thread: ${Thread.currentThread().name}")
//            emit(it)
//        }
//    }
//
//}
//---------------------------------------------------------------------------------------------------
// We can use multiple flowOn operator
// flowOn works upstream

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent { Text(text = "haha") }
//        GlobalScope.launch(Dispatchers.Main) {
//            producer()
//                .map { it * 2  }
//                .flowOn(Dispatchers.IO)// now producer is executing on IO thread
//                .filter {; Log.d("sumit", "filter Thread: ${Thread.currentThread().name}"); it < 100}
//                .flowOn(Dispatchers.Main) // now consumer is executing on Default thread
//                .collect { Log.d("sumit", "Consumer Thread: ${Thread.currentThread().name}") }
//        }
//    }
//}
//
//private fun producer(): Flow<Int> {
//    return flow {
//
//            val list = listOf(1, 2, 3, 4, 5)
//            list.forEach {
//                delay(1000)
//                Log.d("sumit", "Emitter Thread: ${Thread.currentThread().name}")
//                emit(it)
//
//        }
//
//    }
//}
// -----------------------------------------------------------------------------------------------
// Error handling - producer / consumer
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { Text(text = "haha") }
        GlobalScope.launch(Dispatchers.Main) {

            try {

                producer()
                    .collect {
                        Log.d("sumit", "Consumer Thread: $it ${Thread.currentThread().name}")
//                        throw Exception("Error in collector")
                    }


            } catch (e: Exception) {

                Log.d("sumit", "Exception: ${e.message}")

            }

        }
    }
}

private fun producer(): Flow<Int> {
    return flow {

        val list = listOf(1, 2, 3, 4, 5)
        list.forEach {
            delay(1000)
            Log.d("sumit", "Emitter Thread: ${Thread.currentThread().name}")
            emit(it)
            throw Exception("Error Emitter")

        }

    }
        .catch {  // we can handle error in producer using catch operator
            Log.d("sumit", "Exception: ${it.message}")
            // we can have callback
            emit(-1)

        }
}