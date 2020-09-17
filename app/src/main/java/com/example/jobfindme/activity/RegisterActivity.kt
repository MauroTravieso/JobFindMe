package com.example.jobfindme.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jobfindme.R
import com.example.jobfindme.model.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_reg.setOnClickListener {
            if (!fname.text.toString().isEmpty() && !lname.text.toString().isEmpty() && !new_email.text.isEmpty() && !new_password.text.isEmpty()) {

                // Valid email signature
                if (new_email.text.toString().matches(emailPattern.toRegex())) {

                    if (new_password.text.toString().equals(re_password.text.toString())) {

                        var new_user = User(
                            fname.text.toString(),
                            lname.text.toString(),
                            new_email.text.toString(),
                            new_password.text.toString()
                        )

                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("new_user", new_user)
                        setResult(Activity.RESULT_OK, intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_LONG).show()
                        new_password.error = "Password does not match."
                        re_password.error = "Retype password does not match."
                    }
                } else {
                    new_email.error = "Invalid email signature!"
                }

            } else {
                Toast.makeText(this, "Please, complete every field!", Toast.LENGTH_LONG).show()
            }

            if (fname.text.toString().isEmpty()) {
                fname.error = "First name is required."
            }
            if (lname.text.toString().isEmpty()) {
                lname.error = "Last name is required."
            }
            if (new_email.text.toString().isEmpty()) {
                new_email.error = "Email is required."
            }
            if (new_password.text.toString().isEmpty()) {
                new_password.error = "Password is required."
            }
            if (re_password.text.toString().isEmpty()) {
                re_password.error = "Retype password is required."
            }

        }
    }
}