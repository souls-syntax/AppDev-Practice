package com.example.bathdinnerme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavigator()
            }
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("bath") { RewardScreen(R.drawable.bath) }
        composable("dinner") { RewardScreen(R.drawable.dinner) }
        composable("me") { RewardScreen(R.drawable.me) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.waifu), // your waifu here
            contentDescription = "Waifu Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Foreground UI
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Welcome home, darling~ What would you like?",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { navController.navigate("bath") }) { Text("Bath") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("dinner") }) { Text("Dinner") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("me") }) { Text("Me ❤️") }
        }
    }
}

@Composable
fun RewardScreen(imageResId: Int) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
