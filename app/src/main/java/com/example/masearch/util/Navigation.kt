package com.example.masearch.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.masearch.mainui.MainView
import com.example.masearch.MainViewModel
import com.example.masearch.mainui.ParallaxEffect
import com.example.masearch.screen.Screen

@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainView(navController = navController)
        }

        composable(
            route = Screen.SearchScreen.route,
            arguments = listOf(navArgument(name = "searchId") {
                type = NavType.StringType
            })
        ) {
            ParallaxEffect(
                navigateBack = {
                    navController.popBackStack()
                },
                id = it.arguments?.getString("searchId", ""),
                viewModel = viewModel,
            )
        }

    }
}