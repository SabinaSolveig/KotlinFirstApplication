package com.example.kotlinfirstapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinfirstapplication.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}