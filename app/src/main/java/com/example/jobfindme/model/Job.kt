package com.example.jobfindme.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
 data class Job (
    @PrimaryKey
    var jobId: Long,
    var title : String,
    var company : String,
    var status : String,
    var apply: Boolean,
    var location: String,
    var view : String? = null) :
    Serializable {
}

