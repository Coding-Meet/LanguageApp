package com.example.languageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val langRg = findViewById<RadioGroup>(R.id.langRG)

        val sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        langRg.setOnCheckedChangeListener { radioGroup, checkId ->

            val radioButton = findViewById<RadioButton>(checkId)
            editor.putString("code", radioButton.text.toString())
            editor.commit()

            startActivity(Intent(this, LanguageShowActivity::class.java))
        }
    }
}