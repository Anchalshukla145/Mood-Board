package com.example.moodboard1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Tired : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tired)

        val layout = findViewById<LinearLayout>(R.id.tiredLayout)
        val editNote = findViewById<EditText>(R.id.editTiredNote)
        val reflectBtn = findViewById<Button>(R.id.btnTiredReflect)
        val relaxBtn = findViewById<Button>(R.id.btnTiredRelax)
        val actionBtn = findViewById<Button>(R.id.btnTiredAction)
        val response = findViewById<TextView>(R.id.textTiredResponse)
        val emoji = findViewById<TextView>(R.id.tiredEmojiBurst)

        reflectBtn.setOnClickListener {
            val note = editNote.text.toString().trim()
            response.text = if (note.isNotEmpty()) {
                "You've done enough today. Rest is powerful. 🌙"
            } else {
                "No worries. Let your mind drift into peace. ☁️"
            }
            response.visibility = View.VISIBLE
            emoji.visibility = View.VISIBLE
            val anim = AnimationUtils.loadAnimation(this, R.anim.fadein)
            emoji.startAnimation(anim)
        }

        relaxBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1ZYbU82GVz4")) // Lo-fi Chill
            startActivity(intent)
        }

        actionBtn.setOnClickListener {
            val popup = PopupMenu(this, actionBtn)
            popup.menu.add("Take a Nap 💤")
            popup.menu.add("Stretch Gently 🧘")
            popup.menu.add("Drink Water 💧")
            popup.setOnMenuItemClickListener {
                Toast.makeText(this, "Great idea: ${it.title}", Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
