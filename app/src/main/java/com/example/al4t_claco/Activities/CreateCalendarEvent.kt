package com.example.al4t_claco.Activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.al4t_claco.Models.CalendarViewModel
import com.example.al4t_claco.R
import kotlinx.coroutines.launch


class CreateCalendarEvent : AppCompatActivity() {

    private lateinit var tvTitle:TextView
    private lateinit var etEventName :EditText
    private lateinit var etEventLocal :EditText
    private lateinit var etEventDescription :EditText
    private lateinit var btnSelectTime : Button
    private lateinit var btnCreateEvent :Button
    private lateinit var datePicker: DatePicker
    private lateinit var startTime : TimePicker
    private lateinit var endTime : TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.al4t_claco.R.layout.create_calendar_event)

        Log.i("Calendar","Calendar page not showing ");


        tvTitle = findViewById(com.example.al4t_claco.R.id.tvNewEventTitle)
        btnCreateEvent = findViewById(com.example.al4t_claco.R.id.btnCreateEvent)
        etEventName = findViewById(com.example.al4t_claco.R.id.etEventName)
        etEventDescription = findViewById(com.example.al4t_claco.R.id.etEventDescription)
        etEventLocal = findViewById(com.example.al4t_claco.R.id.etEventLocal)
        datePicker = findViewById(com.example.al4t_claco.R.id.datePicker)


        //startTime = findViewById(R.id.tpStartTime)
        //endTime = findViewById(R.id.tpEndTime)

        // using our viewModel
        val activityModel : CalendarViewModel by viewModels();

        fun showDialogTime(){
            val dialogBuilder = AlertDialog.Builder(this)
            //dialogBuilder.setTitle(event.name)
            //dialogBuilder.setMessage()
            val li = LayoutInflater.from(this)
            val myView: View = li.inflate(com.example.al4t_claco.R.layout.event_date_picker, null)
            dialogBuilder.setView(myView)

            dialogBuilder.setPositiveButton(
                com.example.al4t_claco.R.string.close,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    startTime = myView.findViewById<TimePicker>(com.example.al4t_claco.R.id.tpStartTime)
                    endTime = myView.findViewById<TimePicker>(com.example.al4t_claco.R.id.tpEndTime)
                    activityModel._uiState.value = activityModel._uiState.value.copy(startTimeHour = startTime.hour, startTimeMinute = startTime.minute,
                    endTimeHour = endTime.hour, endTimeMinute = endTime.minute)
                    Toast.makeText(this,startTime.hour.toString()+ startTime.minute.toString(), Toast.LENGTH_SHORT).show()
                })
            val b = dialogBuilder.create()
            b.show()
        }


        btnSelectTime = findViewById(com.example.al4t_claco.R.id.btnStartTime)
        btnSelectTime.setOnClickListener {
            showDialogTime()

        }




        btnCreateEvent.setOnClickListener {

            activityModel.create_event(etEventName.text.toString(),etEventLocal.text.toString(),etEventDescription.text.toString(),
            datePicker.year,datePicker.month,datePicker.dayOfMonth);
            Log.i("Create btn ","Create button pressed")

        }

    }
}