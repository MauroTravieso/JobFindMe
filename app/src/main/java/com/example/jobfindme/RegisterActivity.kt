package com.example.jobfindme

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_reg.setOnClickListener {
            if (!fname.text.toString().isEmpty() && !lname.text.toString().isEmpty() && !new_email.text.isEmpty() && !new_password.text.isEmpty()) {

                if (new_password.text.toString().equals(re_password.text.toString())) {
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()

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
                }
            } else {
                Toast.makeText(this, "Please, complete every field!", Toast.LENGTH_LONG).show()
            }

        }
    }
}