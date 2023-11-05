package com.example.masearch.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.masearch.MainActivity
import com.example.masearch.MainView
import com.example.masearch.MainViewModel
import com.example.masearch.ParallaxEffect
import com.example.masearch.screen.Screen

@Composable
fun Navigation(viewModel: MainViewModel, activity: MainActivity) {
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
        ) { it ->
            ParallaxEffect(
                navigateBack = {
                    navController.popBackStack(
                        route = Screen.MainScreen.route,
                        inclusive = false
                    )
                },
                id = it.arguments?.getString("searchId", ""),
                viewModel = viewModel,
                activity = activity
            )
        }

    }
}