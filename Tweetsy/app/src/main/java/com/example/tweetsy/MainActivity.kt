package com.example.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
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
import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.ui.theme.TweetsyTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsyAPI: TweetsyAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            try {
                val response = tweetsyAPI.getCategories()
                if (response.isSuccessful) {
                    Log.d("sumit", "Categories: ${response.body()!!.distinct()}")
                } else {
                    Log.e("sumit", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("sumit", "Exception: ${e.message}")
            }
        }


//        enableEdgeToEdge()
        setContent {
           App()
            TweetsyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = "Android")
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "registration") {
        composable(route = "registration") {
            RegistrationScreen() {
                navController.navigate("main/${it}")
            }
        }
        composable(route = "login") {
            LoginScreen()
        }
        composable(route = "main/{email}", arguments = listOf(
            navArgument("email") {
                type = NavType.StringType
            }
        )) {
            val email = it?.arguments!!.getString("email")
            MainScreen(email!!)
        }
    }
}


@Composable
fun RegistrationScreen(onClick: (email: String) -> Unit) {
    Text(text = "Registration",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.clickable {
            onClick("sumit@gmail.com")
        }
    )
}

@Composable
fun LoginScreen() {
    Text(text = "Login", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun MainScreen(email: String) {
    Text(
        text = "Main Screen - $email",
        modifier = Modifier.clickable {

        },
        style = MaterialTheme.typography.headlineLarge
    )

}