package com.example.al4t_claco.Models

class Student(name: String, email: String, password: String, workspace: List<Course>) :
    User(name, email, password,workspace) {

    val totalCredits: Int = workspace.sumOf { it.credits }

}