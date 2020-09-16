package com.example.jobfindme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btnSingIn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", "Welcome, " + email.text.toString())
            startActivity(intent)
            email.text.clear()
            password.text.clear()
        }
        btnRegister.setOnClickListener {

            startActivity(Intent(this, RegisterActivity::class.java))
            email.text.clear()
            password.text.clear()
        }
    }
}