package com.example.moodboard1

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SnackBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snack_bar)

        val button = findViewById<Button>(R.id.button)
        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)

        button.setOnClickListener {view->
            Snackbar.make(view, "Moved to trash", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo"){ view2-> Snackbar.make(view2,"Restored",Snackbar.LENGTH_LONG).show() }
                .show()

        }
    }
}
