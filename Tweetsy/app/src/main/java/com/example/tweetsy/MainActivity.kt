package com.example.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsy.Screens.CategoryItem
import com.example.tweetsy.Screens.CategoryScreen
import com.example.tweetsy.Screens.DetailScreen
import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.ui.theme.TweetsyTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TweetsyTheme {
                App()
            }
        }
    }
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