package com.example.kotlinfirstapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlinfirstapplication.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getAll() :List<Note>

    @Query("SELECT * FROM Note")
    fun getAllLiveData() :LiveData<List<Note>>

    @Query("SELECT * FROM Note WHERE uid IN (:noteIds)")
    fun loadAllByIds(noteIds: IntArray): List<Note>

    @Query("SELECT * FROM Note WHERE uid = :uid LIMIT 1")
    fun findById(uid: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note?)

    @Update
    fun update(note: Note?)

    @Delete
    fun delete(note: Note?)
}