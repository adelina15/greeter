package com.example.greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val nameEditText = findViewById<EditText>(R.id.name_edit)

        button.setOnClickListener {
            val name = nameEditText.text.toString()
            if (name.isBlank()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else {
                val greetingTextView = findViewById<TextView>(R.id.greeting_text)
                greetingTextView.text = "Hello, $name"
            }
        }
    }
}