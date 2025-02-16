package com.example.androidarchitecture

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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.example.androidarchitecture.ui.theme.AndroidArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        lifecycle.addObserver(observer())
        Log.d("sumit", "Activity OnCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("sumit", "Activity OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("sumit", "Activity OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("sumit", "Activity OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("sumit", "Activity OnDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidArchitectureTheme {
        Greeting("Android")
    }
}