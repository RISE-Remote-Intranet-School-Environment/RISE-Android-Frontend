package com.example.al4t_claco.Models

class Teacher(name: String, email: String, password: String, workspace: List<Course>) :
    User(name, email, password, workspace) {

    fun editCourse(courseCode: String): Boolean{
        return TODO()
    }

    fun editActivity(activityCode: String): Boolean{
        return TODO()
    }




}