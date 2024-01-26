package com.example.bookcatcher.ui.screens

import androidx.compose.runtime.Composable
import com.example.bookcatcher.R
import com.example.bookcatcher.navigation.NavigationDestination

object BookEditScreenDestination: NavigationDestination{
    override val route = "editBook"
    override val titleRes = R.string.edit_book

}

@Composable
fun BookEditScreen(){

}