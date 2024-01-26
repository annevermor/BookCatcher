package com.example.bookcatcher.data

import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    //functions for books
    fun getAllBooksStream(): Flow<List<Book>>

    fun getBookStream(id: Int): Flow<Book?>

    suspend fun insertBook(book: Book)

    suspend fun deleteBook(book: Book)

    suspend fun updateBook(book: Book)

    //functions for positions
    suspend fun insertPosition(readingPos: ReadingPos)

    suspend fun deletePosition(readingPos: ReadingPos)
}