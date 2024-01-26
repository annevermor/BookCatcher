package com.example.bookcatcher.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookcatcher.ui.screens.AddBookScreen
import com.example.bookcatcher.ui.screens.AddBookScreenDestination
import com.example.bookcatcher.ui.screens.BookEditScreen
import com.example.bookcatcher.ui.screens.BookEditScreenDestination
import com.example.bookcatcher.ui.screens.BookshelfScreen
import com.example.bookcatcher.ui.screens.BookshelfScreenDestination
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
            MainScreen(
                navigateToMainScreen = { navController.navigate(MainScreenDestination.route) },
                navigateToBookshelf = { navController.navigate(BookshelfScreenDestination.route) },
                navigateToStatisticsScreen = {navController.navigate(CreditsScreenDestination.route)},
                navigateUp = {navController.navigateUp()}
            )
        }
        composable(route = CreditsScreenDestination.route){
            CreditsScreen()
        }
        composable(route = AddBookScreenDestination.route){
            AddBookScreen()
        }
        composable(route = BookEditScreenDestination.route){
            BookEditScreen()
        }
        composable(BookshelfScreenDestination.route){
            BookshelfScreen()
        }
    }
}