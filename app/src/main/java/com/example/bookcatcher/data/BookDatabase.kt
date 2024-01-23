package com.example.bookcatcher.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class, ReadingPos::class], version = 1, exportSchema = false)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object{
        @Volatile
        private var Instance: BookDatabase? = null
        fun getDatabase(context: Context): BookDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, BookDatabase::class.java, "book_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}