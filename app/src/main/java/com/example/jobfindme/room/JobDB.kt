package com.example.jobfindme.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jobfindme.model.Job


@Database(entities = [Job::class],version = 1)
abstract class JobDB : RoomDatabase() {
    companion object {
        fun dbCreation(application: Application) : JobDB {
            return Room.databaseBuilder(application, JobDB::class.java, "jobdb").build()
        }
    }
    abstract fun getJobDao() : JobDAO

}