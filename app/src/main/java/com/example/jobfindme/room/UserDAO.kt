package com.example.jobfindme.room

import androidx.room.*
import com.example.jobfindme.model.User

@Dao
interface UserDAO {

    // Insert the User received from the API into the Database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user : User)

    @Query("SELECT * FROM User WHERE username like :search")
    fun getUser(search : String) : List<User>
    @Query("SELECT*FROM User")
    fun getAllUsers():List<User>
    @Update
    fun updateUser(user:User)

    @Delete
    fun deleteUser(user:User)
}