package com.example.jobfindme.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.jobfindme.model.User

import java.lang.Exception

class DBController(c: Context){
    lateinit var dbHelper: DBHelper
    var ourContext: Context
    lateinit var database:SQLiteDatabase
    init {
        ourContext=c
    }
    fun open():DBController{
        dbHelper= DBHelper(ourContext)
        database=dbHelper.writableDatabase
        return this
    }
    fun close(){
        dbHelper.close()
    }
    //Inserting, Updating and Deleting Data in to/from Users_Table
    fun InsertUser(user: User):Boolean{
        try {
            val cv=ContentValues()
            cv.put(DBHelper.USER_COLUMN_FIRSTNAME,user.firstName)
            cv.put(DBHelper.USER_COLUMN_LASTNAME,user.lastName)
            cv.put(DBHelper.USER_COLUMN_USERNAME,user.username)
            cv.put(DBHelper.USER_COLUMN_PASSWORD,user.password)
            database.insert(DBHelper.USER_TABLE,null,cv)
        }catch (e:Exception){
            return false
        }
        return true
    }
    fun getAllUsers(): Cursor {
        val allColumns= arrayOf<String>(DBHelper.USER_COLUMN_FIRSTNAME,DBHelper.USER_COLUMN_LASTNAME,DBHelper.USER_COLUMN_USERNAME,DBHelper.USER_COLUMN_PASSWORD)
        val c=database.query(DBHelper.USER_TABLE,allColumns,null,null,null,null,null)
        c?.moveToFirst()
        return c
    }
    // Update the record in the Table
    fun updateUser(user:User):Int {
        val cvUpdate = ContentValues()
        cvUpdate.put(DBHelper.USER_COLUMN_USERNAME, user.firstName)
        cvUpdate.put(DBHelper.USER_COLUMN_USERNAME, user.lastName)
        cvUpdate.put(DBHelper.USER_COLUMN_USERNAME, user.username)
        cvUpdate.put(DBHelper.USER_COLUMN_PASSWORD, user.password)
        val i = database.update(DBHelper.USER_TABLE, cvUpdate,
            DBHelper.USER_COLUMN_USERNAME + " = " + user.username, null)
        return i
    }
    // Deleting record data from table by NAME
    fun deleteUser(userName:Long) {
        database.delete(DBHelper.USER_TABLE, (DBHelper.USER_COLUMN_USERNAME + "="
                + userName), null)
    }
}