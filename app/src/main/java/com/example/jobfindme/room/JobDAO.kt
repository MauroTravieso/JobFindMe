package com.example.jobfindme.room

import androidx.room.*
import com.example.jobfindme.model.Job

@Dao
interface JobDAO {

    // Insert the User received from the API into the Database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertJob(job : Job)

    @Query("SELECT * FROM Job WHERE jobId like :search")
    fun getJob(search : String) : List<Job>

    @Update
    fun updateJob(job: Job)

    @Delete
    fun deleteJob(job: Job)
}