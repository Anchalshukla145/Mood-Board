package com.example.moodboard1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val sadBtn = findViewById<ImageButton>(R.id.moodsad)
        sadBtn.setOnClickListener {
            val intent = Intent(this, sadmood::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        }
        val happyBtn = findViewById<ImageButton>(R.id.moodhappy)
        happyBtn.setOnClickListener {
            val intent = Intent(this, Happy::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        }

        // Angry mood button
        val angryBtn = findViewById<ImageButton>(R.id.moodangry)
        angryBtn.setOnClickListener {
            val intent = Intent(this, Angry::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        }
        // Tired mood button
        val tiredBtn=findViewById<ImageButton>(R.id.moodtired)
        tiredBtn.setOnClickListener {
            val intent = Intent(this, Tired::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        }

// Relaxed mood button
        val relaxedBtn=findViewById<ImageButton>(R.id.moodrelaxed)
        relaxedBtn.setOnClickListener {
            val intent = Intent(this, Relaxed::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        }

// Excited mood button
        val ExcitedBtn=findViewById<ImageButton>(R.id.moodexcited)
        ExcitedBtn.setOnClickListener {
            val intent = Intent(this, excited::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        }

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(m: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, m)
        return true
    }
}
