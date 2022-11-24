package com.example.al4t_claco.Models

import java.time.LocalDateTime

class Event (name: String, location: Classroom, val startDate: LocalDateTime, val endDate: LocalDateTime, description: String){
    val name = name
    val location = location
    val description = description
}