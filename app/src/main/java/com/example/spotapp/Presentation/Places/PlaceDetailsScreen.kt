package com.example.spotapp.Presentation.Places

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.spotapp.Data.Model.TipEntity

@Composable
fun PlaceDetailsScreen(
    backStackEntry: NavBackStackEntry,
    navController: NavController,  // Include NavController to handle navigation
    viewModel: PlaceViewModel = viewModel()  // ViewModel to interact with data logic
) {
    val placeId = backStackEntry.arguments?.getString("placeId")  // Get place ID from nav args

    // Call the getPlaceById function from ViewModel and fetch the details of the place
    viewModel.getPlaceById(placeId ?: "") // Trigger fetching place details
    val place = viewModel.selectedPlace.collectAsState().value // Collect the current state of the selected place
    val ratingSuccess = viewModel.ratingSuccess.collectAsState().value // Collect the success state of the rating

    // Call function to fetch tips for this place
    LaunchedEffect(placeId) {
        viewModel.fetchTipsForPlace(placeId ?: "")
    }
    val tips = viewModel.tips.collectAsState().value // Collect the list of tips for this place

    // Display your place details here
    place?.let {
        // If place is found, display its details
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Display place name and address
            Text(text = "Place Name: ${it.name}")
            Text(text = "Address: ${it.address}")

            Spacer(modifier = Modifier.height(16.dp))  // Space between elements

            // Rating Button
            Button(
                onClick = {
                    viewModel.ratePlace(it.id, "Yes! It's okay")  // Call ViewModel function to submit a rating
                }
            ) {
                Text(text = "Rate this Place")
            }

            // Show success/failure feedback for rating
            if (ratingSuccess == true) {
                Text("Rating submitted successfully!")
            } else if (ratingSuccess == false) {
                Text("Failed to submit rating.")
            }

            Spacer(modifier = Modifier.height(16.dp))  // Space between buttons

            // Add to List Button
            Button(
                onClick = {
                    viewModel.addPlaceToList(it)  // Call ViewModel function to add place to list
                }
            ) {
                Text(text = "Add to List")
            }

            Spacer(modifier = Modifier.height(16.dp))  // Space between buttons

            // Navigate to the list screen after adding the place (optional)
            Button(
                onClick = {
                    navController.navigate("list_screen")  // Replace with actual list screen route
                }
            ) {
                Text(text = "Go to My Lists")
            }

            Spacer(modifier = Modifier.height(24.dp))  // Space before tips section

            // Tips Section - Allow users to add and view tips
            Text("Tips for this Place:", style = androidx.compose.ui.text.TextStyle(fontSize = 18.sp))

            // Display the list of tips for this place
            Column(modifier = Modifier.fillMaxWidth()) {
                tips.forEach { tip ->
                    Text("- ${tip.content} (User: ${tip.username})", modifier = Modifier.padding(4.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))  // Space before adding new tip section

            // Section to add a new tip
            var tipContent by remember { mutableStateOf("") }  // State for holding tip content
            BasicTextField(
                value = tipContent,
                onValueChange = { tipContent = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                decorationBox = { innerTextField ->
                    Box(Modifier.padding(8.dp)) {
                        if (tipContent.isEmpty()) {
                            Text("Add a tip...", color = androidx.compose.ui.graphics.Color.Gray)
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))  // Space between input and button

            // Button to submit a new tip
            Button(
                onClick = {
                    val username = "CurrentUser"  // Replace with the actual username from user data
                    val newTip = TipEntity(
                        placeId = placeId ?: "",
                        userId = "currentUserId",  // Replace with the actual userId
                        username = username,
                        content = tipContent,
                        timestamp = System.currentTimeMillis()
                    )
                    viewModel.addTipForPlace(newTip)  // Call ViewModel to add the new tip
                    tipContent = "" // Clear input field after adding the tip
                },
                modifier = Modifier.align(Alignment.End)  // Align button to the right
            ) {
                Text(text = "Add Tip")
            }
        }
    } ?: run {
        // Handle the case where the place is not found
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Place not found")
        }
    }
}

