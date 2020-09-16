package com.example.jobfindme

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    // List of Users initialization
    var users = ArrayList<User>()

    // Users
    val admin = User("admin","admin","admin@mail.com","admin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Populate the user list
        users.add(admin)

        btnSingIn.setOnClickListener {
            if (!email.text.toString().isEmpty() && !password.text.toString().isEmpty()) {
                val eml = email.text.toString()
                val pss = password.text.toString()

                for (user in users) {
                    if (eml.equals(user.username) && pss.equals(user.password)) {
                        // Sending the intent to MainActivity
                        var intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("username", "Hello, " + email.text.toString())
                        startActivity(intent)
                        email.text.clear()
                        password.text.clear()
                        Toast.makeText(this, "Welcome, $eml", Toast.LENGTH_LONG).show()
                    }
                }
            }
            if (email.text.toString().isEmpty()) {
                email.error = "Email is required."
            }
            if (password.text.toString().isEmpty()) {
                password.error = "Password is required."
            }

        }

        btnRegister.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
//            email.text.clear()
//            password.text.clear()

            var intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent,1)
            email.text.clear()
            password.text.clear()
        }
    }

    var regist = false

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val new_user = data!!.getSerializableExtra("new_user")
                for (user in users) {
                    if (regist == false){
                        if (!user.equals(new_user)) {
                            users.add(new_user as User)
                            regist = true
                            Toast.makeText(this, "Account created successfully. \nPlease, Sign In", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this, "Register unsuccessful!!! \nEmail account already exists!", Toast.LENGTH_LONG).show()
                        //regist = false
                    }
                }
            }
        }
    }


    var reg = false

    fun forgotPassword(view : View) {
        val eml = email.text.toString()
        if (eml.isEmpty()) {
            Toast.makeText(
                this,
                "Forgot password? \nPlease, enter a registered email!",
                Toast.LENGTH_LONG
            ).show()
            email.error = "Please, enter an Email."
        } else {
            for (user in users) {
                if (reg == false) {
                    if (eml.equals(user.username)) {
                        val fpass = user.password
                        // Implicit intent
                        val intent = Intent()
                        intent.action = Intent.ACTION_SEND
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_TEXT, fpass)
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent)
                        }
                        reg = true
                    }
                } else {
                    email.error = "Email is not registered."
                    Toast.makeText(
                        this,
                        "The email provided is not registered!",
                        Toast.LENGTH_LONG
                    ).show()
                    //reg = false
                }
            }
        }
    }
}