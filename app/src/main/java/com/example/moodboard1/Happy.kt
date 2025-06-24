package com.example.moodboard1

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Happy : AppCompatActivity() {
    lateinit var happyImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_happy)

        // Toolbar setup
        val toolbar = findViewById<Toolbar>(R.id.happyToolbar)
        setSupportActionBar(toolbar)

        // Input and response
        val input = findViewById<EditText>(R.id.happyReasonInput)
        val submitButton = findViewById<Button>(R.id.happySubmitButton)
        val responseText = findViewById<TextView>(R.id.happyResponseText)

        submitButton.setOnClickListener {
            val userResponse = input.text.toString().trim()
            if (userResponse.isNotEmpty()) {
                responseText.text = "Great! 😊"
            } else {
                responseText.text = "Please tell me why you're happy!"
            }
            responseText.visibility = View.VISIBLE
        }

        // Songs
        val playSong1 = findViewById<Button>(R.id.playSong1)
        val playSong2 = findViewById<Button>(R.id.playSong2)

        playSong1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=TOTHJvHamYc"))
            startActivity(intent)
        }

        playSong2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=jZhQOvvV45w"))
            startActivity(intent)
        }

        // Context menu setup for image
        happyImage = findViewById(R.id.happyImage)
        registerForContextMenu(happyImage)
    }

    // Inflate toolbar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Inflate context menu
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    // Handle context menu item selection
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.rotate -> {
                happyImage.rotation += 45f
                Toast.makeText(this, "Image rotated", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.filter -> {
                happyImage.setColorFilter(Color.YELLOW)
                Toast.makeText(this, "Yellow filter applied", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.clear -> {
                happyImage.clearColorFilter()
                happyImage.rotation = 0f
                Toast.makeText(this, "Effects cleared", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}
