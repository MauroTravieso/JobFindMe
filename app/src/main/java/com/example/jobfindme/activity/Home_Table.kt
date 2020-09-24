package com.example.jobfindme.activity

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.database.Cursor
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.jobfindme.R
import com.example.jobfindme.database.DBcontrollerJob
import com.example.jobfindme.model.Job
import com.example.jobfindme.model.User
import com.example.jobfindme.room.UserDAO
import com.example.jobfindme.room.UserDB
import com.google.firebase.database.core.Context
import kotlinx.android.synthetic.main.activity_home__table.*

class Home_Table : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__table)


        val intt = intent
        val output = intt.getStringExtra("jobtitle")
        val dbController=DBcontrollerJob()
        lateinit var jobs: ArrayList<String>
        var c:Cursor  =dbController.getAllJobs()
        var title=c.getString(c.getColumnIndex("title"))
        var company=c.getString(c.getColumnIndex("company"))
        var location=c.getString(c.getColumnIndex("location"))
        var apply=c.getString(c.getColumnIndex("apply"))
        var status=c.getString(c.getColumnIndex("status"))
        var view=c.getString(c.getColumnIndex("view"))

        if(output==title){
            textView1.text=title
            textView2.text=company
            textView3.text=location
            textView4.text=apply
            textView5.text=status
            textView6.text=view
        }

    }
}