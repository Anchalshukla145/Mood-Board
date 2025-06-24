package com.example.moodboard1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Angry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_angry)

        // Toolbar setup
        val toolbar = findViewById<Toolbar>(R.id.angryToolbar)
        setSupportActionBar(toolbar)

        // Views
        val input = findViewById<EditText>(R.id.editAngerInput)
        val ventBtn = findViewById<Button>(R.id.ventAngerBtn)
        val breatheBtn = findViewById<Button>(R.id.breatheBtn)
        val punchPillowBtn = findViewById<Button>(R.id.punchPillowBtn)
        val angerQuote = findViewById<TextView>(R.id.angerQuote)

        // Handle Vent Button
        ventBtn.setOnClickListener {
            val userInput = input.text.toString().trim()
            if (userInput.isNotEmpty()) {
                angerQuote.text = "It's okay to feel angry. Express it safely and let it pass. 🧘"
            } else {
                angerQuote.text = "Even if you can’t say it, breathe deeply. You’ll feel better soon. 🌿"
            }
            angerQuote.visibility = View.VISIBLE
        }

        // Handle Breathing Button
        breatheBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=LiUnFJ8P4gM"))
            startActivity(intent)
        }

        // Handle Punch Pillow Button
        punchPillowBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://poki.com/en/g/smash-it"))
            startActivity(intent)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

}
