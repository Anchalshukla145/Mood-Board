package com.example.moodboard1

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class excited : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_excited)

        val layout = findViewById<LinearLayout>(R.id.excitedLayout)
        val sw = findViewById<Switch>(R.id.switchExcit)
        val editNote = findViewById<EditText>(R.id.editExcitedNote)
        val btn1 = findViewById<Button>(R.id.btnShowText1)
        val btn2 = findViewById<Button>(R.id.btnShowText2)
        val text1 = findViewById<TextView>(R.id.textExcite1)
        val text2 = findViewById<TextView>(R.id.textExcite2)
        val appResponse = findViewById<TextView>(R.id.appExcitementResponse)
        val prompt = findViewById<TextView>(R.id.excitementPrompt)
        val emoji = findViewById<TextView>(R.id.emojiBurst)

        sw.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                layout.setBackgroundResource(R.drawable.gradient)
            } else {
                layout.setBackgroundColor(Color.parseColor("#FFB347"))
            }
        }

        btn1.setOnClickListener {
            val message = editNote.text.toString().trim()
            if (message.isNotEmpty()) {
                text1.visibility = View.VISIBLE
                appResponse.text = "Wow! That sounds amazing. I can feel your excitement! 🎉"
                appResponse.visibility = View.VISIBLE
                prompt.visibility = View.VISIBLE

                val animation = AnimationUtils.loadAnimation(this, R.anim.pop_in)
                emoji.visibility = View.VISIBLE
                emoji.startAnimation(animation)
                text2.visibility = View.GONE
            } else {
                text1.text = "Write a little about what excites you first!"
                text1.visibility = View.VISIBLE
                text2.visibility = View.GONE
            }
        }

        btn2.setOnClickListener {
            text2.visibility = View.VISIBLE
            text1.visibility = View.GONE
        }
        val btnAction = findViewById<Button>(R.id.btnShowText2)

        btnAction.setOnClickListener {
            val popupMenu = PopupMenu(this, btnAction)
            popupMenu.menuInflater.inflate(R.menu.exite_actions, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        Toast.makeText(this, "Sharing excitement with friends!", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_enjoy -> {
                        Toast.makeText(this, "Let’s enjoy this moment!", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_dance -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RDnJ3NVz4WA"))
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }

            popupMenu.show()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
