package com.example.ca1_execution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelGuideApp()
        }
    }
}

@Composable
fun TravelGuideApp() {

    var isLoaded by remember { mutableStateOf(false) }

    if (isLoaded) {
        TouristPlacesList()
    } else {
        SplashScreen {
            isLoaded = true
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(5000)
        onTimeout()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Travel Guide App", fontSize = 26.sp)
    }
}

@Composable
fun TouristPlacesList() {

    val placesList = listOf("Varanasi", "Ayodhya", "Manali", "Mount Everest", "Amritsar")

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        items(placesList) { place ->
            Text(text = place)

        }
    }
}




