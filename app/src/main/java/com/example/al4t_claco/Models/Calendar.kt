package com.example.al4t_claco.Models

import java.time.LocalDate
import java.util.*

class Calendar(val events: List<Event>) {
    val eventsPerDay :MutableMap<LocalDate, MutableList<Event>> = HashMap()
    init {
        for(event in events){
            //val date = event.dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
            val date = event.startDate.toLocalDate()
            if(eventsPerDay.containsKey(date)){
                eventsPerDay[date]!!.add(event)
            }
            else{
                eventsPerDay[date] = mutableListOf<Event>(event)
            }


        }
    }


}