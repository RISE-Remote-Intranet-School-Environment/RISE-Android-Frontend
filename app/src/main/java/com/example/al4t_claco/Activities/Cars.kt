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

class Cars : AppCompatActivity() {

    private lateinit var tvCar:TextView
    private lateinit var btnIncrement :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)


        val viewModel: CarViewModel by viewModels()
        btnIncrement = findViewById(R.id.btnIncrement)
        btnIncrement.setOnClickListener {
            viewModel.add_km(1);
            //Toast.makeText(this,viewModel.uiState.value.km.toString(),Toast.LENGTH_SHORT).show()

        }



        tvCar = findViewById<TextView>(R.id.tvCar)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { carUiState  ->
                    // Update UI elements
                    tvCar.text = carUiState.km.toString()
                }
            }
        }
    }
}