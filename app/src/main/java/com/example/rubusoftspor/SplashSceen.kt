package com.example.rubusoftspor

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashSceen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_sceen)
        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}