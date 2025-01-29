package com.example.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Text(text = "Hello sumit thsis is myuf sdfnlkfndkfdggng  ng fgndg l");
            TextInput2()
        }
    }
}


//@Composable
//fun sayHello(name: String) {
//    Text(
//        text = "Hi $name!",
//        fontStyle = FontStyle.Italic,
//        fontWeight = FontWeight.ExtraBold,
//        color = Color.Red,
//        fontSize = 36.sp,
//        textAlign = TextAlign.Right
//
//
//    )
//}
//
//// generally we create preview function for non default parameter composable function
//@Preview(
//    showBackground = true,
//    name = "hello message",
////  showSystemUi = true,
//    widthDp = 200,
//    heightDp = 200
//)
//@Composable
//private fun previewFunction() {
//    sayHello("Sumit")
//}
//
//@Preview(showBackground = true, widthDp = 200, heightDp = 200)
//@Composable
//fun previewFunction2() {
//    Image(
//        painter = painterResource(id = R.drawable.heart),
//        contentDescription = "heart",
//        colorFilter = ColorFilter.tint(Color.Blue),
//        contentScale = ContentScale.Crop
//    )
//}
//
//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
//@Composable
//private fun buttonFunction() {
//    Button(
//        onClick = {},
//        colors = ButtonDefaults.buttonColors(
//            contentColor = Color.White,
//
//            ),
//        enabled = false // now it is disable state
//    ) {
//        Text(text = "hello")
//        Image(
//            painter = painterResource(id = R.drawable.images),
//            contentDescription = "button with image"
//        )
//    }
//}
//
//@Preview
//@Composable
//private fun inputText() {
//    TextField(
//        value = "Hello sumit",
//        onValueChange = {},// what happens when value change
//        label = {Text(text = "Enter message")}, // expect compose
//        placeholder = {}
//        )
//}

//@Preview
@Composable
fun TextInput() {
    TextField(

        value = "Hello sumit",
        onValueChange = {
            Log.d("myYippee", it) // to logcat changes
        },
        label = { Text(text = "Enter Message") }
    )
}// here value is static we can not change value in ui
// to do it let's write another function

@Composable
fun TextInput2() {
    val state = remember { mutableStateOf("") } // remember function remember previous state value
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d("sumitg" , it)
        },
        label = { Text(text = "Enter Message") },
    )
}



