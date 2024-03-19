package com.example.bookcatcher.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import com.example.bookcatcher.BookTopAppBar
import com.example.bookcatcher.R
import com.example.bookcatcher.navigation.NavigationDestination

object AddBookScreenDestination: NavigationDestination{
    override val route = "addBook"
    override val titleRes = R.string.add_book
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBookScreen(){

    Scaffold (
        topBar = {
        BookTopAppBar(
            title = stringResource(R.string.app_name),
            canNavigateBack = false,
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        )
    },) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}