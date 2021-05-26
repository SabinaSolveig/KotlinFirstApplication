package com.example.kotlinfirstapplication.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Note : Serializable{
    @PrimaryKey(autoGenerate = true)
    var uid = 0

    @ColumnInfo(name = "text")
    var text: String = ""

    @ColumnInfo(name = "timestamp")
    var timestamp: Long = 0

    @ColumnInfo(name = "done")
    var done = false
}
