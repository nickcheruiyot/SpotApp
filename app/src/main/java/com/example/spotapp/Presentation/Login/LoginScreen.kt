package com.example.spotapp.Presentation.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.spotapp.Presentation.Navigation.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    // Observing UI state from ViewModel
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login to SpotApp")

        // Button to trigger login action
        Button(onClick = {
            viewModel.login()
            // Navigate to the Map screen after login
            navController.navigate(Screen.Map.route)
        }) {
            Text(text = "Login")
        }

        // Displaying loading state if applicable
        if (uiState.isLoading) {
            Text(text = "Logging in...")
        }
    }
}