package com.example.kotlin_learning

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun MediaCompose() { // fix it
    var context = LocalContext.current
    val button = remember { mutableStateOf(false) }

//    Button(onClick = { button.value = !button.value }) {
//        Text(text = "Start")
//    }

    DisposableEffect(key1 = button.value) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.media)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}