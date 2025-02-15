package com.example.coroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
        CoroutineScope(Dispatchers.IO).launch {
            execute()
        }

    }

    private suspend fun execute() {
        val parentJob = CoroutineScope(Dispatchers.IO).launch {

            for (i in 1..1000) {
                if (isActive) {
                    ExecuteLongRunningTask()
                    Log.d("sumit", i.toString())
                }

            }
        }
        delay(100)
        Log.d("sumit", "Canceling Job")
        parentJob.cancel() // job should be cancel but it is not happening
        // because job busy to execute the task
        // we need to check the job is active or not
        // so if job is not active then it will not execute
        parentJob.join()
        Log.d("sumit", "Parent Job Completed")
    }

    private fun ExecuteLongRunningTask() {
        for (i in 1..1000000000) {

        }
    }

}



