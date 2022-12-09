package com.example.al4t_claco.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.al4t_claco.Models.CarViewModel
import com.example.al4t_claco.R
import kotlinx.coroutines.launch

class CreateCalendarEvent : AppCompatActivity() {

    private lateinit var tvCar:TextView
    private lateinit var btnIncrement :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_calendar_event)




    }
}