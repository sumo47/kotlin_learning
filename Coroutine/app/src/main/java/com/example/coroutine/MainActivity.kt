package com.example.coroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
        CoroutineScope(Dispatchers.Main).launch {
            printFollowers()
        }

    }


//    private suspend fun printFollowers() {
//        var fbFollowers = 0;
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getFbFollowers()
//        }
//        // job will execute on coroutine so below code will execute first
//        job.join() // now below code will execute when job will complete
//        Log.d("sumit", fbFollowers.toString())
//
//    }
//
//    private suspend fun getFbFollowers(): Int {
//        delay(100)
//        return 54
//    }


    // we can do this using async await ---------------
//    private suspend fun printFollowers() {
//        val fbFollowers = CoroutineScope(Dispatchers.IO).async {
//            getFbFollowers()
//        }
//        Log.d("sumit", fbFollowers.await().toString())
//
//    }
//
//    private suspend fun getFbFollowers(): Int {
//        delay(100)
//        return 54
//    }

    // we can run multiple parallel coroutine using async await ---------------
    private suspend fun printFollowers() {
        CoroutineScope(Dispatchers.IO).launch {
            val fbFollowers = async { getFbFollowers() } // takes 1 sec
            val instaFollowers = async { getFbFollowers() } // takes 1 sec
            Log.d( // takes 1 sec because both job running parallel
                "sumit",
                "fbFollowers: ${fbFollowers.await()} , instaFollowers: ${instaFollowers.await()}"
            )
        }

    }

    private suspend fun getFbFollowers(): Int {
        delay(1000)
        return 54
    }

}



