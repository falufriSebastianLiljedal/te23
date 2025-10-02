package com.example.te23

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var button : Button = findViewById<Button>(R.id.btn_home)
        button.setOnClickListener {
            ClickOnHome(button)
        }

        val accountButton: Button = findViewById<Button>(R.id.btn_account)
        accountButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            val textBox: EditText = findViewById<EditText>(R.id.editTextText)
            val username = textBox.text.toString()

            intent.putExtra("username", username)
            startActivity(intent)
        }
    }

    fun ClickOnHome(button : Button){
        button.text = "I'm so clicked"
    }
}