package com.example.jobfindme.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jobfindme.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    companion object {
        fun dbCreation(application: Application) : UserDB {
            return Room.databaseBuilder(application, UserDB::class.java, "userdb").build()
        }
    }

    abstract fun getUserDao() : UserDAO

}