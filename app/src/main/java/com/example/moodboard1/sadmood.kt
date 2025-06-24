package com.example.moodboard1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge

class sadmood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sadmood)

        // ✅ Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.sadToolbar)
        setSupportActionBar(toolbar)

        // UI elements
        val ventButton = findViewById<Button>(R.id.ventEverythingBtn)
        val littleBoostButton = findViewById<Button>(R.id.littleVentBtn)
        val editThoughts = findViewById<EditText>(R.id.editThoughts)
        val text2 = findViewById<TextView>(R.id.motivationText2)
        val text3 = findViewById<TextView>(R.id.motivationText3)
        val boost = findViewById<Button>(R.id.watchUpliftingBtn)

        // Hide text views initially
        text2.visibility = View.GONE
        text3.visibility = View.GONE

        // Button logic
        ventButton.setOnClickListener {
            val userInput = editThoughts.text.toString().trim()
            if (userInput.isNotEmpty()) {
                Log.d("MoodCheck", "You had a long day. It's okay, you did your best.")
                text2.text = "You had a long day. It's okay, you did your best."
            } else {
                Log.d("MoodCheck", "It's okay if you don't feel like to share. Just know that you did a good job.")
                text2.text = "It's okay if you don't feel like to share. Just know that you did a good job."
            }
            text2.visibility = View.VISIBLE
            text3.visibility = View.GONE
        }

        littleBoostButton.setOnClickListener {
            text3.text = "“Keep going. Everything you need will come to you at the perfect time.”"
            text3.visibility = View.VISIBLE
            text2.visibility = View.GONE
        }

        boost.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qNm8lPcyJOk"))
            startActivity(intent)
        }
    }

    // Inflate the toolbar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Optional: handle menu clicks

}
