package com.example.bookcatcher.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.stringResource
import com.example.bookcatcher.R
import com.example.bookcatcher.navigation.NavigationDestination

object BookshelfScreenDestination: NavigationDestination{
    override val route = "bookshelf"
    override val titleRes = R.string.bookshelf

}

@Composable
fun BookshelfScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(R.string.nothing_to_show))
        FloatingActionButton(onClick = { /*TODO*/ }) {
            
        }
    }
}