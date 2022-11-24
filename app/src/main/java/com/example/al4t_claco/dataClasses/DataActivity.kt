package com.example.al4t_claco.dataClasses

import com.example.al4t_claco.Models.Activity


data class DataActivity(private val activity: Activity, val course: String){


    val name = activity.name
    val code = activity.code
    val teachers = activity.teachers.joinToString(", ")
    val description = activity.description

    val files = activity.resources





}
