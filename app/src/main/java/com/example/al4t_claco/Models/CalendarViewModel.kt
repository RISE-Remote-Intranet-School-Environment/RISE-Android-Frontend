package com.example.al4t_claco.Models

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime

data class CalendarUIState(
    var startTimeHour: Int? = 12,
    var startTimeMinute: Int? = 0,
    var endTimeHour : Int? =13,
    var endTimeMinute : Int? =0
)


class CalendarViewModel : ViewModel() {
    val _uiState = MutableStateFlow(CalendarUIState())
    //val uiState: StateFlow<CalendarUIState> = _uiState.asStateFlow()

    private val activities = mutableListOf<Activity>();
    private val courses = mutableMapOf<Int,Course>();
    private val events = mutableListOf<Event>();


    fun get_events():List<Event>{
        val date1 = LocalDateTime.of(2021, 12, 13, 8, 30)
        val date2 = LocalDateTime.of(2021, 12, 13, 12, 0)

        val date3 = LocalDateTime.of(2021, 12, 17, 8, 30)
        val date4 = LocalDateTime.of(2021, 12, 17, 12, 0)

        val date5 = LocalDateTime.of(2021, 12, 17, 12, 45)
        val date6 = LocalDateTime.of(2021, 12, 17, 14, 0)

        val date9 = LocalDateTime.of(2021, 12, 15, 12, 45)
        val date10 = LocalDateTime.of(2021, 12, 15, 16, 0)

        val date7 = LocalDateTime.of(2021, 12, 15, 8, 30)
        val date8 = LocalDateTime.of(2021, 12, 15, 12, 0)

        val event1 = Event("SA4L-L1-4MIN", Classroom("1E06"), date1, date2, "Programmation parallèle  OpenGL\nGroupe : 4MIN\nEns : LUR")
        val event2 = Event("DD4L-L1-4MIN", Classroom("1G01"), date3, date4, "Labo architecture et qualité logicielle\nGroupe : 4MIN\nEns : J3L")
        val event3 = Event("AL4T-T1-4MIN", Classroom("1G01"), date5, date6, "architecture et qualité logicielle\nGroupe : 4MIN\nEns : J3L")
        val event4 = Event("SI4C-L1-4MIN", Classroom("1F04"), date7, date8, "Labo instrumentation\nGroupe : 4MIN\nEns : MCH, MDM")
        val event5 = Event("OS4T-T1-4MEO-4MIN", Classroom("1G01"), date9, date10, "Systèmes d'exploitation\nGroupe: 4MIN\nEns : HSL, XEI")
        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);
        return events;
    }
    fun create_event(name:String,local:String,desc:String,year:Int,month:Int,dayOfMonth:Int){
        val startTimeHour = _uiState.value.startTimeHour
        val startTimeMinute = _uiState.value.startTimeMinute
        val endTimeHour = _uiState.value.endTimeHour
        val endTimeMinute = _uiState.value.endTimeMinute
        val month = if(month!=0) month else 1
        if (startTimeHour !=null && startTimeMinute !=null && endTimeHour !=null && endTimeMinute !=null) {
            val start =LocalDateTime.of(year, month, dayOfMonth, startTimeHour, startTimeMinute)
            val end = LocalDateTime.of(year, month, dayOfMonth, endTimeHour, endTimeMinute)
            events.add(Event(name, Classroom(local), start, end, desc))
            Log.i("New Event Name", "New event added :" +events.get(events.size - 1).name.toString())
            //Log.i("New Event", events.get(events.size - 1).description.toString())
            //Log.i("New Event", events.get(events.size - 1).startDate.dayOfMonth.toString())
        } else {
            Log.i("Create_event", "Creation didn't work")

        }

    }

}