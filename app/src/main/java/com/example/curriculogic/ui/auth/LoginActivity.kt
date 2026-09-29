package com.example.curriculogic.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.curriculogic.ui.main.MainActivity
import com.example.curriculogic.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. Connect the XML elements to Kotlin code
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val tvError = findViewById<TextView>(R.id.tvError)

        // 2. Handle the Login Button click
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Check for empty fields
            if (email.isEmpty() || password.isEmpty()) {
                tvError.text = "Email and password cannot be empty"
                tvError.visibility = View.VISIBLE
                return@setOnClickListener
            }

            // Hide error, show loading
            tvError.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            btnLogin.isEnabled = false

            // Simulate a network request
            lifecycleScope.launch {
                delay(1500) // Wait 1.5 seconds

                progressBar.visibility = View.GONE
                btnLogin.isEnabled = true

                // Dummy check for now
                if (email == "admin@curriculogic.com" && password == "password123") {
                    // Login Successful! Go to Main Activity
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Close login screen so user can't go back
                } else {
                    tvError.text = "Invalid email or password"
                    tvError.visibility = View.VISIBLE
                }
            }
        }
    }
}