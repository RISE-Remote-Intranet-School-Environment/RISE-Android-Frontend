package com.example.al4t_claco.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.al4t_claco.R
import java.util.ArrayList

class ForumAnswer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_answer)

        //val Question = findViewById<TextView>(R.id.Question)

        val listViewAnswers = findViewById<ListView>(R.id.ListViewAnswers)

        val listOfAnswers = ArrayList<String>()

        //TODO : Get this from the API instead of creating them here

        listOfAnswers.add("I don't know why.")
        listOfAnswers.add("Because it is.")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfAnswers)

        listViewAnswers.adapter = adapter

        val newAnswer = findViewById<EditText>(R.id.NewAnswer)
        val btnNewAnswer = findViewById<Button>(R.id.btn_NewAnswer)

        btnNewAnswer.setOnClickListener{
            if (newAnswer.text.toString() != ""){
                listOfAnswers.add(newAnswer.text.toString());
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfAnswers)
                listViewAnswers.adapter = adapter
                newAnswer.text.clear()
            }else{
                Toast.makeText(this, "Empty answer", Toast.LENGTH_SHORT).show()
            }
        }
    }
}