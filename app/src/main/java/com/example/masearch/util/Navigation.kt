package com.example.masearch.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.masearch.mainui.MainView
import com.example.masearch.mainui.ParallaxEffect
import com.example.masearch.screen.Screen
import com.example.masearch.view.like.LikeCharacterView
import com.example.masearch.view.recent.RecentSearchView


//todo 화면 전환시 애니메이션 추가할 것
//todo https://stackoverflow.com/questions/65643015/animating-between-composables-in-navigation-with-compose 참조
@Composable
fun Navigation() {
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
            )
        }

        composable(route = Screen.LikeScreen.route) {
            LikeCharacterView(navController = navController, navigateBack = {
                navController.popBackStack()
            })
        }

        composable(route = Screen.RecentSearchScreen.route) {
            RecentSearchView(
                navController = navController,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}