package com.example.kotlinfirstapplication.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfirstapplication.App
import com.example.kotlinfirstapplication.model.Note

class MainViewModel : ViewModel() {
    private val noteLiveData: LiveData<List<Note>> =
        App.getInstance().getNoteDao().getAllLiveData()

    fun getNoteLiveData(): LiveData<List<Note>> {
        return noteLiveData
    }
}