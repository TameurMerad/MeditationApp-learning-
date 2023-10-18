package com.example.composefirst.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route ){
           composable(route = Screens.MainScreen.route){
               MainScreen(navController = navController)
           }
            composable(
                route = Screens.SecoundScreen.route + "/{title}",
                arguments = listOf(navArgument("title"){
                        type = NavType.StringType
                    defaultValue = "soufyan"
                    nullable = true
                    })
            ){entry ->
                SecoundScreen(title = entry.arguments?.getString("title"))
            }

    }


}