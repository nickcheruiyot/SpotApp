package com.example.spotapp.Presentation.Search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.spotapp.Domain.Model.Category
import com.example.spotapp.R

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    onCategorySelected: (String) -> Unit
) {
    val categories = listOf(
        Category("Breakfast", R.drawable.ic_breakfast),
        Category("Lunch", R.drawable.ic_lunch),
        Category("Dinner", R.drawable.ic_dinner),
        Category("Coffee", R.drawable.ic_coffee),
        Category("Nightlife", R.drawable.ic_nightlife),
        Category("Schools", R.drawable.ic_school)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                CategoryItem(
                    category = category,
                    onClick = { onCategorySelected(category.name) }
                )
            }
        }

        // Displaying places based on the selected category
        val places by viewModel.places.collectAsState()
        if (places.isNotEmpty()) {
            // Show a list of places based on the fetched data
        }
    }
}
