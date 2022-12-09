package com.example.al4t_claco.Models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ActivitiesUIState(
    var name: String,
    var code: String,
    var teachers: List<String> ,
    var description :String
)


class DashboardViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ActivitiesUIState("","", listOf(""),""))
    val uiState: StateFlow<ActivitiesUIState> = _uiState.asStateFlow()
    private val activities = mutableListOf<Activity>();
    private val courses = mutableMapOf<Int,Course>();



    fun get_all_activities():List<Activity>{
        //val activities = mutableListOf<Activity>();
        val activity = Activity("Activity 1","4inf", listOf("Lorge","Lurkin","Dekimpe"),"This is the description of activity 1")
        val activity2 = Activity("Activity 2","4inf", listOf("Lorge","Lurkin","Dekimpe"),"This is the description of activity 2")
        val activity3 = Activity("Activity 3","4inf", listOf("Lorge","Lurkin","Dekimpe"),"This is the description of activity 3")
        val activity4 = Activity("Parallel programming, OpenGL","4inf", listOf("Lurkin"),"Notions present in this course : memory management in C++, 3D render with OpenGL ...")
        val activity5 = Activity("Algorithmic","4inf", listOf("Hasselmann"),"This course is about algorithms, it will cover the basics on algorithmic complexity, data structures and their applications. The course will feature exercices along the way and a small presentation and the end of the session")
        val activity6 = Activity("Image processing lab","4inf", listOf("Lurkin","Madmad"),"Notions present in this course : filtering, morphological operations, projective geometry ...")
        activity.resources = listOf(File("file 1","pdf"), File("file 2","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity2.resources = listOf(File("file 1","pdf"), File("file 2","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity3.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity4.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity5.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity6.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activities.add(activity);
        activities.add(activity2);
        activities.add(activity3);
        activities.add(activity4);
        activities.add(activity5);
        activities.add(activity6);
        return activities;
    }

    fun get_all_courses():Map<Int,Course>{
        val course = Course("GPU Computing","4inf",4,5,"Lur","This course deals with GPU Computing", activities.slice(0..2))
        val course1 = Course("Database","4DB",4,5,"Lor","This course deals with database", activities.slice(2..4))
        val course2 = Course("APPS","4app",4,5,"LRK","This course deals with APPS", activities.slice(1..3))
        val course3 = Course("Electronics","4el",4,5,"MCH","This course deals with electronics", activities.slice(3..5))
        val course4 = Course("Electricity","4inf",4,5,"CMS","This course deals with electricity", activities.slice(1..4))
        courses[0] = course;
        courses[1] = course1;
        courses[2] = course2;
        courses[3] = course3;
        courses[4] = course4;
        return courses;
    }
}