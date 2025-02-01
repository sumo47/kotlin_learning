package com.example.blogapptheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blogapptheme.ui.theme.BlogAppThemeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var theme = remember { mutableStateOf(false) }

    BlogAppThemeTheme(theme.value) {
       Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
           Text(
               text = "Sumit kumar",
               modifier = Modifier.padding(top = 30.dp),
               style = MaterialTheme.typography.headlineMedium
           )
           Button(
               onClick = { theme.value = !theme.value },
           ) {
               Text(text = "Change Theme")
           }
       }
    } // if we have a function that wants lambda function in last parameter , than we can write like this
    // both are valid
//            BlogAppThemeTheme (content = { Text(text = "Sumit kumar") })
}

