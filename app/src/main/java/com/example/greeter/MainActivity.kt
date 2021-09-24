package com.example.greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.internal.NavigationMenu
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var name: String
    private lateinit var greetingTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val nameEditText = findViewById<EditText>(R.id.name_edit)

        button.setOnClickListener {
            name = nameEditText.text.toString()
            if (name.isBlank()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                greetingTextView = findViewById(R.id.greeting_text)
                greetingTextView.text = "Hello, $name"
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("username", name)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        name = savedInstanceState.getString("username", "")
        greetingTextView = findViewById(R.id.greeting_text)
        greetingTextView.text = "Hello, $name"
        super.onRestoreInstanceState(savedInstanceState)

    }
}
