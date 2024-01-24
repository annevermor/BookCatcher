package com.example.bookcatcher.data

import kotlinx.coroutines.flow.Flow

class OfflineBooksRepository(private val bookDao: BookDao): BooksRepository {
    override fun getAllBooksStream(): Flow<List<Book>> = bookDao.getAllBooks()

    override fun getBookStream(id: Int): Flow<Book?> = bookDao.getBook(id)

    override suspend fun deleteBook(book: Book) = bookDao.delete(book)

    override suspend fun insertBook(book: Book) = bookDao.insert(book)

    override suspend fun insertPosition(readingPos: ReadingPos) = bookDao.insertPosition(readingPos)

    override suspend fun updateBook(book: Book) = bookDao.update(book)
}