package com.example.jobfindme.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBJob(context: Context): SQLiteOpenHelper(context,DB_NAME,null, DB_VERSION){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_JOBS)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_JOBS)
        onCreate(db)
    }
    companion object{
        //Database Information
        val DB_NAME="jobfindme.db"
        val DB_VERSION=3
        //Login-User Table Information
        val JOB_TABLE="Jobs"
        val JOB_COLUMN_JOBID="jobId"
        val JOB_COLUMN_TITLE="title"
        val JOB_COLUMN_COMPANY="company"
        val JOB_COLUMN_LOCATION="location"
        val JOB_COLUMN_Apply="apply"
        val JOB_COLUMN_status="status"
        val JOB_COLUMN_VIEW="view"
        val CREATE_TABLE_JOBS="CREATE TABLE If not exists $JOB_TABLE(" +
                "$JOB_COLUMN_TITLE TEXT NOT NULL," +
                "$JOB_COLUMN_COMPANY TEXT," +"$JOB_COLUMN_LOCATION TEXT,"+"$JOB_COLUMN_Apply boolean,"+
                "$JOB_COLUMN_status TEXT," +
                "$JOB_COLUMN_VIEW TEXT," +
                "PRIMARY KEY($JOB_COLUMN_JOBID)" +")"
        val DROP_TABLE_JOBS="DROP TABLE IF EXISTS $JOB_TABLE"
    }
}