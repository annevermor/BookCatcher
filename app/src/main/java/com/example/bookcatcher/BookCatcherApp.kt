package com.example.bookcatcher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bookcatcher.navigation.BookNavHost
import com.example.bookcatcher.ui.screens.BookshelfScreenDestination
import com.example.bookcatcher.ui.screens.MainScreenDestination

@Composable
fun BookCatcherApp(navController: NavHostController = rememberNavController()){
    BookNavHost(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}

@Composable
fun BookBottomAppBar(
    navigateToBookshelf: () -> Unit,
    navigateToMainScreen: () -> Unit,
    navigateToStatisticsScreen: () -> Unit
) {
    NavigationBar(modifier = Modifier.height(60.dp)) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        )
        {
            IconButton(onClick = navigateToMainScreen) {
                Icon(
                    painter = painterResource(id =R.drawable.donut_chart),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null,
                )
            }
            IconButton(
                onClick = navigateToBookshelf
            ) {
                Icon(painter = painterResource(id =R.drawable.library), contentDescription = null)
            }
            IconButton(onClick = navigateToStatisticsScreen) {
                Icon(painter = painterResource(id =R.drawable.grading), contentDescription = null)
            }
        }

    }
}