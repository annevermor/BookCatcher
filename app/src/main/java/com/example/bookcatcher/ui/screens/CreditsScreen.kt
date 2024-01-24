package com.example.bookcatcher.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookcatcher.R
import com.example.bookcatcher.navigation.NavigationDestination
import com.example.compose.BookCatcherTheme

object CreditsScreenDestination : NavigationDestination {
    override val route = "credits"
    override val titleRes = R.string.credits
}

@Composable
fun CreditsScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        Card(
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
                    Image(
                        painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null
                    )
                Text(
                    text = stringResource(R.string.developer),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("annevermor@gmail.com", modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreditsScreenPreview() {
    BookCatcherTheme(useDarkTheme = true) {
        CreditsScreen()
    }
}