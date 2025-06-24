package com.example.moodboard1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Relaxed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relaxed)

        val layout = findViewById<LinearLayout>(R.id.relaxedLayout)
        val editNote = findViewById<EditText>(R.id.editRelaxNote)
        val btnReflect = findViewById<Button>(R.id.btnRelaxReflect)

        val textResponse = findViewById<TextView>(R.id.textRelaxResponse)
        val emoji = findViewById<TextView>(R.id.relaxEmojiBurst)
        val btnPrompt = findViewById<Button>(R.id.btnPrompt)
        val textPrompt = findViewById<TextView>(R.id.textPrompt)
        val btnMusic = findViewById<Button>(R.id.btnPlayCalmMusic)
        val btnNature = findViewById<Button>(R.id.btnNatureVideo)
        val btnStretch = findViewById<Button>(R.id.btnStretch)
        val btnAction = findViewById<Button>(R.id.btnRelaxAction)

        btnReflect.setOnClickListener {
            val input = editNote.text.toString().trim()
            if (input.isNotEmpty()) {
                textResponse.text = "It's wonderful to feel relaxed. Take a moment to enjoy it. ☁️"
                textResponse.visibility = View.VISIBLE
                emoji.text = "🌿😊💤"
                emoji.visibility = View.VISIBLE
                emoji.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pop_in))
            } else {
                textResponse.text = "Even a quiet mind deserves recognition. ☁️"
                textResponse.visibility = View.VISIBLE
                emoji.text = "🧘🌼🌈"
                emoji.visibility = View.VISIBLE
                emoji.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pop_in))
            }
        }

        btnPrompt.setOnClickListener {
            val prompts = listOf(
                "What made you feel most calm today?",
                "Did you do something kind for yourself today?",
                "How can you keep this peace tomorrow?"
            )
            textPrompt.text = prompts.random()
            textPrompt.visibility = View.VISIBLE
        }

        btnMusic.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=2OEL4P1Rz04"))
            startActivity(intent)
        }

        btnNature.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1ZYbU82GVz4"))
            startActivity(intent)
        }

        btnStretch.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qULTwquOuT4"))
            startActivity(intent)
        }

        btnAction.setOnClickListener {
            val popup = PopupMenu(this, btnAction)
            popup.menu.add("Read a calming book")
            popup.menu.add("Do 3-min yoga")
            popup.menu.add("Take a mindful walk")

            popup.setOnMenuItemClickListener { item ->
                when (item.title) {
                    "Read a calming book" -> textResponse.text = "Try a chapter from your favorite book or a poem. 📖"
                    "Do 3-min yoga" -> textResponse.text = "Even a short stretch can renew your body and mind. 🧘"
                    "Take a mindful walk" -> textResponse.text = "Step outside and just observe. Breathe. 🌳"
                }
                textResponse.visibility = View.VISIBLE
                emoji.text = "🌈💗"
                emoji.visibility = View.VISIBLE
                emoji.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pop_in))
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
