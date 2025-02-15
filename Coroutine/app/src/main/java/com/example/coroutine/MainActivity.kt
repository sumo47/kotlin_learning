package com.example.coroutine

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text(text = "Hello World!")
        }
        // viewModelScope has launched coroutines for us automatically
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // let create another Activity and finish mainAcitvity so mainviewmodel will destroy
        // redirect to another activity
        lifecycleScope.launch {
            delay(2000)
            val intent = Intent(this@MainActivity, AnotherActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

}

//output -

//Before
//Inside
//After




