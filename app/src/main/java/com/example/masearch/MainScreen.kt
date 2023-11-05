package com.example.masearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.masearch.screen.Screen


@Composable
fun MainView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen 1")
        Button(onClick = { navController.navigate(Screen.SearchScreen.searchCharacter("test")) }) {
            Text(text = "Navigate to next screen")
        }
    }
}

@Composable
fun SearchScreen2(navigateBack: () -> Unit, id: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$id")

        Button(onClick = navigateBack) {
            Text(text = "Navigate to back")
        }
    }
}
