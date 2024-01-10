package com.example.trabalho_pmeu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        var textLogin = findViewById<TextView>(R.id.textView5)
        textLogin.setOnClickListener {
            val intent1 = Intent (this,LoginPage::class.java)
            startActivity(intent1)
        }
    }
}