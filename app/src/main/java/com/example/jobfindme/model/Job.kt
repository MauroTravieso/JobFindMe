package com.example.jobfindme.model

class Job {

    /// MOdel class
    var title : String? = null
    var company : String? = null
    var status : String? = null
    var view : String? = null

    constructor(){

    }

    constructor(title: String?, company: String?, status: String?,view : String?) {
        this.title = title
        this.company = company
        this.status = status
        this.view=view
    }
}