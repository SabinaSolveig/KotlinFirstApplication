package com.example.kotlinfirstapplication

import android.app.Application
import androidx.room.Room
import com.example.kotlinfirstapplication.data.AppDatabase
import com.example.kotlinfirstapplication.data.NoteDao

class App : Application() {

    companion object {
        private lateinit var instance: App
        private lateinit var database: AppDatabase
        private lateinit var noteDao: NoteDao

        fun getInstance(): App {
          return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-db-name"
        )
            .allowMainThreadQueries()
            .build()
        noteDao = database.noteDao()
    }

    fun getNoteDao(): NoteDao {
        return noteDao
    }
}