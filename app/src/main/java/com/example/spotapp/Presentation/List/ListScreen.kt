package com.example.spotapp.Presentation.List

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spotapp.Presentation.Navigation.Screen

@Composable
fun ListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Lists",
            modifier = Modifier
                .padding(vertical = 16.dp),
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge
        )

        // Section 1: Saved Places
        ListSection(
            title = "Saved Places",
            onClick = { navController.navigate(Screen.PlaceList.route) } // Navigates to PlaceList
        )

        // Section 2: Liked Places
        ListSection(
            title = "Liked Places",
            onClick = { navController.navigate(Screen.PlaceList.route) } // Navigates to PlaceList (Liked)
        )

        // Section 3: Create a New List
        ListSection(
            title = "Create a New List",
            onClick = { /* Add logic to create a new list or navigate to a form */ }
        )
    }
}

@Composable
fun ListSection(
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
        )
    }
}