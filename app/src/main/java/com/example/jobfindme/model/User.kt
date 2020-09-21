package com.example.jobfindme.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User(
    val firstName:String,
    val lastName:String,
    @PrimaryKey
    val username:String,
    val password:String) :
    Serializable {
}