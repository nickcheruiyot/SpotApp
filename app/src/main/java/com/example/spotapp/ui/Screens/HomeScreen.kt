package com.example.spotapp.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable


fun HomeScreen (navController: NavHostController){    // Sample data: List of places (replace with real data)
    val places = remember {
        listOf("1" to "Coffee Shop", "2" to "Electronics Store", "3" to "Gym", "4" to "Hospital")
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Welcome to SpotApp!", style = MaterialTheme.typography.headlineSmall)

        LazyColumn {
            items(places) { (id, name) ->
                Button(
                    onClick = { navController.navigate("details/$id") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Text(name)
                }
            }
        }
    }

}