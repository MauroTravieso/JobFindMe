package com.example.jobfindme.activity

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.jobfindme.R
import com.example.jobfindme.model.User
import com.example.jobfindme.room.UserDAO
import com.example.jobfindme.room.UserDB

class Home_Table : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__table)
    }
}