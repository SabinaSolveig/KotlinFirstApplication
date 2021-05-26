package com.example.kotlinfirstapplication.screens.details

import com.example.kotlinfirstapplication.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.kotlinfirstapplication.App
import com.example.kotlinfirstapplication.model.Note
import java.util.*

class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var note: Note
    private lateinit var editText: EditText

    companion object {
        private const val EXTRA_NOTE = "NoteDetailsActivity.EXTRA_NOTE"
        fun start(caller: Activity, note: Note?) {
            val intent = Intent(caller, NoteDetailsActivity::class.java)
            if (note != null) {
                intent.putExtra(EXTRA_NOTE, note)
            }
            caller.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_note_details)
        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        title = getString(R.string.note_details_title)
        editText = findViewById(R.id.text)
        if (intent.hasExtra(EXTRA_NOTE)) {
            note = intent.getSerializableExtra(EXTRA_NOTE) as Note
            editText.setText(note.text)
        } else {
            note = Note()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> if (editText.text.length > 0) {
                note.text = editText.text.toString()
                note.done = false
                note.timestamp = System.currentTimeMillis()
                if (intent.hasExtra(EXTRA_NOTE)) {
                    App.getInstance().getNoteDao().update(note)
                } else {
                    App.getInstance().getNoteDao().insert(note)
                }
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}