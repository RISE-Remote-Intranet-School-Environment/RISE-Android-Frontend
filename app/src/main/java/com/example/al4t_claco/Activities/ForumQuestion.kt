package com.example.al4t_claco.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.al4t_claco.Models.sessionManager
import com.example.al4t_claco.R
import java.util.*

class ForumQuestion : AppCompatActivity() {

    lateinit var session: sessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_question)

        //SESSION INFORMATION

        session = sessionManager(applicationContext)
        session.checkLogin()

        //

        val listViewQuestions = findViewById<ListView>(R.id.listViewQuestions)

        val listOfQuestions = ArrayList<String>()

        //TODO : Get this from the API instead of creating them here

        listOfQuestions.add("Why?")
        listOfQuestions.add("When?")
        listOfQuestions.add("Who?")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfQuestions)

        listViewQuestions.adapter = adapter

        val btnAnswer = findViewById<Button>(R.id.answer)

        btnAnswer.setOnClickListener{
            startActivity(Intent(applicationContext, ForumAnswer::class.java))
        }

        val newQuestion = findViewById<EditText>(R.id.newQuestion)
        val btnNewQuestion = findViewById<Button>(R.id.addQuestion)

        btnNewQuestion.setOnClickListener{
            if (newQuestion.text.toString() != ""){

                listOfQuestions.add(newQuestion.text.toString());
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfQuestions)
                listViewQuestions.adapter = adapter
                newQuestion.text.clear()
            }else{
                Toast.makeText(this, "Empty question", Toast.LENGTH_SHORT).show()
            }
        }
    }
}