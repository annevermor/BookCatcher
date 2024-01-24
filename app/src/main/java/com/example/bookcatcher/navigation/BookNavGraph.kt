package com.example.bookcatcher.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookcatcher.ui.screens.CreditsScreen
import com.example.bookcatcher.ui.screens.CreditsScreenDestination
import com.example.bookcatcher.ui.screens.MainScreen
import com.example.bookcatcher.ui.screens.MainScreenDestination

@Composable
fun BookNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = MainScreenDestination.route
    ){
        composable(route = MainScreenDestination.route){
            MainScreen()
        }
        composable(route = CreditsScreenDestination.route){
            CreditsScreen()
        }
    }
}