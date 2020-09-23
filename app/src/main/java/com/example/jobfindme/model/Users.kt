package com.example.jobfindme.model

class Users {

    /// MOdel class
    var name : String? = null
    var status : String? = null
    var image : String? = null

    constructor(){

    }

    constructor(name: String?, status: String?, image: String?) {
        this.name = name
        this.status = status
        this.image = image
    }
}