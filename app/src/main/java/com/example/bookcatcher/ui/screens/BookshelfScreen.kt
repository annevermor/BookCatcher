package com.example.bookcatcher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookcatcher.R
import com.example.bookcatcher.data.Book
import com.example.bookcatcher.navigation.NavigationDestination
import com.example.bookcatcher.ui.theme.AllColors
import com.example.compose.BookCatcherTheme

object BookshelfScreenDestination: NavigationDestination{
    override val route = "bookshelf"
    override val titleRes = R.string.bookshelf

}

@Composable
fun BookshelfScreen(books: List<Book>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(books, key = {it.id}){book ->
            BookCard(book)
        }
    }
}

@Composable
fun BookCard(book: Book){
    Card() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(text = book.author)
            Text(text = "${book.currentPage}/${book.pageNumbers}")
            LinearProgressIndicator(
                progress = (book.currentPage/book.pageNumbers.toFloat()),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun BookCover(book: Book){
    var cover = Brush.verticalGradient(colors = listOf(MaterialTheme.colorScheme.primary,MaterialTheme.colorScheme.onPrimary))
    Column (modifier = Modifier
        .size(70.dp, 100.dp)
        .background(cover)
    ) {

    }
}

@Preview
@Composable
fun BookshelfPreview(){
    BookCatcherTheme(useDarkTheme = true) {
        BookshelfScreen(
            books = listOf(
                Book(author = "Anton Novikov", title = "Magnum Opus", currentPage = 10, id = 1, pageNumbers = 200),
                Book(author = "Lev Tolstoy", title = "Anna Karenina", currentPage = 300, id = 2, pageNumbers = 400),
                Book(author = "Stephen King", title = "It", currentPage = 0, id = 3, pageNumbers = 1000),
            )
        )
    }

}

@Preview
@Composable
fun BookCoverPreview(){
    BookCatcherTheme(useDarkTheme = true) {
        BookCover(
            Book(author = "Anton Novikov", title = "Magnum Opus", currentPage = 10, id = 1, pageNumbers = 200)
        )
    }
}