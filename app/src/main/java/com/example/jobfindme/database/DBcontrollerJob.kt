package com.example.jobfindme.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.jobfindme.model.Job



import java.lang.Exception

class DBcontrollerJob () {
    lateinit var dbJob: DBJob
    lateinit var ourContext: Context
    lateinit var database: SQLiteDatabase
    constructor(c:Context) : this() {

        ourContext=c
    }
    init {

    }
    fun open():DBcontrollerJob{
        dbJob= DBJob(ourContext)
        database=dbJob.writableDatabase
        return this
    }
    fun close(){
        dbJob.close()
    }
    //Inserting, Updating and Deleting Data in to/from Users_Table
    fun InsertJob(job: Job):Boolean{
        try {
            val cv= ContentValues()
            cv.put(DBJob.JOB_COLUMN_JOBID,job.jobId)
            cv.put(DBJob.JOB_COLUMN_TITLE,job.title)
            cv.put(DBJob.JOB_COLUMN_COMPANY,job.company)
            cv.put(DBJob.JOB_COLUMN_LOCATION,job.location)
            cv.put(DBJob.JOB_COLUMN_Apply,job.apply)
            cv.put(DBJob.JOB_COLUMN_status,job.status)
            cv.put(DBJob.JOB_COLUMN_VIEW,job.view)
            database.insert(DBJob.JOB_TABLE,null,cv)
        }catch (e: Exception){
            return false
        }
        return true
    }
    fun getAllJobs(): Cursor {
        val allColumns= arrayOf<String>(DBJob.JOB_COLUMN_JOBID,DBJob.JOB_COLUMN_TITLE,DBJob.JOB_COLUMN_COMPANY,DBJob.JOB_COLUMN_LOCATION,DBJob.JOB_COLUMN_Apply,DBJob.JOB_COLUMN_status,DBJob.JOB_COLUMN_VIEW)
        val c=database.query(DBJob.JOB_TABLE,allColumns,null,null,null,null,null)
        c?.moveToFirst()
        return c
    }

    // Update the record in the Table
    fun updateJobs(job: Job):Int {
        val cvUpdate = ContentValues()
        cvUpdate.put(DBJob.JOB_COLUMN_JOBID,job.jobId)
        cvUpdate.put(DBJob.JOB_COLUMN_TITLE,job.title)
        cvUpdate.put(DBJob.JOB_COLUMN_COMPANY,job.company)
        cvUpdate.put(DBJob.JOB_COLUMN_LOCATION,job.location)
        cvUpdate.put(DBJob.JOB_COLUMN_Apply,job.apply)
        cvUpdate.put(DBJob.JOB_COLUMN_status,job.status)
        cvUpdate.put(DBJob.JOB_COLUMN_VIEW,job.view)
        val i = database.update(DBJob.JOB_TABLE, cvUpdate,
            DBJob.JOB_COLUMN_JOBID + " = " + job.jobId, null)
        return i
    }
    // Deleting record data from table by NAME
    fun deleteJob(jobId:Long) {
        database.delete(DBJob.JOB_TABLE, (DBJob.JOB_COLUMN_JOBID + "="+ jobId), null)
    }
}