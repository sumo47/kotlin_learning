package com.example.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.tweetsy.Screens.CategoryScreen
import com.example.tweetsy.Screens.DetailScreen
import com.example.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TweetsyTheme {
                Scaffold(
                    topBar = { AppTopBar() }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        App()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = { Text(text = "Tweetsy") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        )
    )
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {

        composable(route = "category") {
            CategoryScreen() { navController.navigate("detail/${it}") }
//          CategoryScreen(onClick = {navController.navigate("detail/$it")}) // anonymous function
        }

        composable(
            route = "detail/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
            // arguments - is property that we use in composable function
            // kya arguments list accept karta h ?
            // navArgument - is function call that creates NavArgument Object
            // category - is name of an Argument , we will access argument using this name
            // {...} - is lambda function where we configure NavArgument , here we will give detail of argument
        )
        {
            DetailScreen()
        }

    }
}