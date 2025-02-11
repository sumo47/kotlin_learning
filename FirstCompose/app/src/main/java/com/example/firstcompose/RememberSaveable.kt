package com.example.firstcompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun NotificationCounter() {
    // var count = remember { mutableStateOf(0) } // when we rotate our display , the count getting reset

    var count = rememberSaveable() { mutableStateOf(0) }
    // { mutableStateOf(0) } is a lambda function that gets passed as an argument to rememberSaveable(). It ensures that the state is only initialized when needed, improving efficiency and preserving state across recompositions and configuration changes. 🚀
    Column(
//        modifier = Modifier.size(500.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have sent ${count.value} notifications")
        Button(onClick = {
            count.value++
            Log.d("CODERSTAG", "Button Clicked")
        }) {
            Text(text = "Send Notification")
        }
    }
}