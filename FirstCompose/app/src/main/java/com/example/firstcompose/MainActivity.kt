package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import screens.QuoteDetail
import screens.QuoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if(DataManager.isDataLoaded.value){
       if(DataManager.currentPage.value == Pages.LISTING){
           QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
           }
       }else{
           DataManager.currentQuote?.let { QuoteDetail(quote = it) }
       }
    }else{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ){
            Text(text = "Loading...",
                style = MaterialTheme.typography.headlineMedium)
        }
    }
}
enum class Pages{
    LISTING,
    DETAIL
}


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            var count = rememberSaveable() { mutableStateOf(0) }
////           Recomposable()
//           Column (
//               verticalArrangement = Arrangement.Center,
//               horizontalAlignment = Alignment.CenterHorizontally,
//               modifier = Modifier.fillMaxSize(1f)
//           ){
//               Notification(count.value) { count.value++ }
//               MessageBar(count.value)
//           }
//        }
//    }
//}

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            circularImage(
//                R.drawable.ironman,
//                "Logo"
//
//            )
//        }
//    }
//}

// parameterized modifier
//@Composable
//fun circularImage(ImageId: Int, contentDescription: String) {
//    Row(
//        horizontalArrangement = Arrangement.Center,
//        modifier = Modifier.size(width = 200.dp, height = 200.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Image(
//            modifier = Modifier
//                .padding(8.dp)
//                .clip(CircleShape)
//                .border(4.dp, Color.Green, CircleShape),
//            painter = painterResource(id = ImageId),
//            contentDescription = contentDescription
//        )
//    }
//}


// modifier
//@Preview(widthDp = 300, heightDp = 500, showBackground = true)
//@Composable
//private fun previewFunction(){
//    Text(
//        text = "Hello",
//        color = Color.White,
//        modifier = Modifier.background(Color.Blue) // modifier chaining , works like pipeline
//            // border has not been applied on whole Text box
//            // blue -> size -> padding -> border -> circular -> yellow
//            .size(200.dp)
//            .padding(36.dp)
//            .border(4.dp, Color.Red)
//            .clip(CircleShape)
//            .background(Color.Yellow)
//            .clickable {  } // clickable has been applied on yellow area
//
//    )
//}


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//           Column(Modifier.padding(vertical = 50.dp)) {
//               ListViewItem(R.drawable.user, "Sumit kumar", "Web Developer")
//               ListViewItem(R.drawable.user, "Abhishek kumar", "Software Developer")
//               ListViewItem(R.drawable.user, "Nitish Sarkar", "Cloud Developer")
//               ListViewItem(R.drawable.user, "Aman Rawat", "App Developer")
//           }
//        }
//    }
//}
//
//// profile card (parameterized composable)
//
//@Composable
//private fun ListViewItem(imageId:Int , name:String , occupation: String) {
//    Row(Modifier.padding(8.dp)) {
//        Image(
//            painter = painterResource(id = imageId),
//            contentDescription = "userProfile",
//            Modifier.size(40.dp)
//        )
//        Column(verticalArrangement = Arrangement.Center) {
//            Text(text = name, fontWeight = FontWeight.Bold)
//            Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)
//        }
//    }
//}
//
//// create Profile card ( custome composable)
//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
//@Composable
//private fun previewFunction() {
//    Row(Modifier.padding(8.dp)) {
//        Image(
//            painter = painterResource(id = R.drawable.user),
//            contentDescription = "userProfile",
//            Modifier.size(40.dp),
//        )
//        Column(verticalArrangement = Arrangement.Center) {
//            Text(text = "Sumit kumar", fontWeight = FontWeight.Bold)
//            Text(text = "Software Developer", fontWeight = FontWeight.Thin, fontSize = 12.sp)
//        }
//    }
//}

//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
//@Composable
//private fun previewFunction() {
//   Box(// content in z axis
//       contentAlignment = Alignment.BottomEnd
//   ) {
//       Image(painter = painterResource(id = R.drawable.heart), contentDescription = "heart")
//       Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "arrow" )
//   }
//}

//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
//@Composable
//private fun previewFunction() {
//    Row( // horizontally Arrange
//        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically
//    )
//    {
//        Text(text = "A", fontSize = 24.sp)
//        Text(text = "A", fontSize = 24.sp)
//    }
//}


// Column
//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
//@Composable
//fun previewFunction() {
//
//    Column(
//        verticalArrangement = Arrangement.SpaceEvenly,
//        horizontalAlignment = Alignment.CenterHorizontally
//    )
//    { // vertically Arrange
//
//        Text(text = "A", fontSize = 24.sp)
//        Text(text = "B", fontSize = 24.sp)
//    }
//}


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
//@Composable
//fun TextInput() {
//    TextField(
//
//        value = "Hello sumit",
//        onValueChange = {
//            Log.d("myYippee", it) // to logcat changes
//        },
//        label = { Text(text = "Enter Message") }
//    )
//}// here value is static we can not change value in ui
// to do it let's write another function

//@Composable
//fun TextInput2() {
//    val state = remember { mutableStateOf("") } // remember function remember previous state value
//    TextField(
//        value = state.value,
//        onValueChange = {
//            state.value = it
//            Log.d("sumitg" , it)
//        },
//        label = { Text(text = "Enter Message") },
//    )
//}



