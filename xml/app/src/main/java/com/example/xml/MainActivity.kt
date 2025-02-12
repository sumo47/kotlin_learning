package com.example.xml

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
import com.example.xml.ui.theme.XmlTheme

// we extend ComponentActivity to use activity lifecycle methods and now MainActivity is being activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // somehow mainActivity got kill and we wannt to save some data for recreation of activity (onCreate) ,
        // we use onStateInstance to save that data in Bundle, and to access we use savedInstanceState:Bundle
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            XmlTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        Log.d("MainActivity", "onCreate:")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart:")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume:")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause:")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop:")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy:")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart:")
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
    XmlTheme {
        Greeting("Android")
    }
}