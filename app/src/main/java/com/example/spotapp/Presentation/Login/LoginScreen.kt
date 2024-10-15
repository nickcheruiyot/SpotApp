package com.example.spotapp.Presentation.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

        Button(onClick = {
            viewModel.login()
            navController.navigate(Screen.Map.route)
        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate to the SignUpScreen
        Button(onClick = { navController.navigate(Screen.SignUp.route) }) { // Navigate to SignUpScreen
            Text(text = "Don't have an account? Sign Up")
        }

        if (uiState.isLoading) {
            Text(text = "Logging in...")
        }
    }
}