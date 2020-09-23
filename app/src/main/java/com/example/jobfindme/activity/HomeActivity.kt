package com.example.jobfindme.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jobfindme.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_sign_in.*


class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        button_search.setOnClickListener{
            var intent = Intent(this, Home_Table::class.java)
            intent.putExtra("jobtitle", " " + jobtitle.text.toString())
            startActivity(intent)
        }
    }

}