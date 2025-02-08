package com.example.kotlin_learning

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedState() {
    val counter = remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter.intValue = 10
    }
    Counter(counter.intValue)
}

//@Composable
//fun Counter(value: Int) {
////    LaunchedEffect(key1 = Unit) { // if we do not provide value as dependancy than it will take the value of counter when it is 0 and log 0 , now it will not run again because lack of key1 = Unit ,
//    LaunchedEffect(key1 = value) { // now function will run when value changes, and first time, so we will get updated value
//        delay(2000)
//        Log.d("Counter", "Counter is $value")
//    }
//    Text(
//        text = "Counter is $value",
//        modifier = Modifier.padding(top = 40.dp)
//    )
//}

// our LaunchedEffect runs twice , but we want to run it once and log updated value
@Composable
fun Counter(value: Int) {
    val state = rememberUpdatedState(newValue = value) // explore more
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("Counter", "Counter is ${state.value}") // it will log updated value, because of we using state , and state stores updated value because of  rememberUpdatedState() - they store updated value on it
    }
    Text(
        text = "Counter is $value",
        modifier = Modifier.padding(top = 20.dp)
    )


}