package com.example.al4t_claco.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.al4t_claco.Models.*
import com.example.al4t_claco.R
import com.example.al4t_claco.dataClasses.DashboardData
import com.google.android.material.navigation.NavigationView

/* This is the class that shows the page workspace, where the user is going to be able to
 *  see the courses in which he is registered to.
*/
class Dashboard  : AppCompatActivity() {
    var adapter: CustomAdapter? =null
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var session: sessionManager
    lateinit var utilisateur : HashMap<String,String>

    private lateinit var drawerLayout :DrawerLayout
    private lateinit var navView :NavigationView
    private lateinit var user :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        session = sessionManager(applicationContext)
        session.checkLogin()

        supportActionBar?.title = "Workspace"

        //SIDE MENU

        drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        navView = findViewById<View>(R.id.navView) as NavigationView
        val headerView = navView.getHeaderView(0)
        user = headerView.findViewById<TextView>(R.id.user)

        utilisateur = session.getUserDetails()
        var name :String = utilisateur.get(sessionManager.companion.KEY_NAME)!!
        var cou : String = utilisateur.get(sessionManager.companion.KEY_COURSE)!!

        user.text = name

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> startActivity(Intent(this, Dashboard::class.java))
                R.id.nav_calendar -> startActivity(Intent(applicationContext, CalendarActivity::class.java))
                R.id.nav_forum -> Toast.makeText(applicationContext,"Clicked Forum", Toast.LENGTH_SHORT).show()
                R.id.password -> startActivity(Intent(applicationContext, ChangePassword::class.java))
                R.id.logout -> session.logoutdUser()
            }
            false
        }

        //TODO : Get this from the API instead of creating them here
        //CREATE ACTIVITIES AND COURSES
        // integrating view model
        val activityModel : DashboardViewModel by viewModels()

        val activitiesList = activityModel.get_all_activities()

        val coursesDict = activityModel.get_all_courses();
        val default_course = Course("undefined","/",4,5,"/","This course is unavailable", activitiesList.slice(0..2))


        val courseNames = mutableListOf<DashboardData>();

        for (course in coursesDict.values){
            courseNames.add(DashboardData(course?:default_course,R.drawable.ic_launcher_foreground));
        }

        val course_logo = DashboardData(coursesDict[0]?:default_course,R.drawable.ic_launcher_foreground)
        val course_logo1 = DashboardData(coursesDict[1]?:default_course,R.drawable.ic_launcher_foreground)
        val course_logo2 = DashboardData(coursesDict[2]?:default_course,R.drawable.ic_launcher_foreground)
        val course_logo3 = DashboardData(coursesDict[3]?:default_course,R.drawable.ic_launcher_foreground)
        val course_logo4 = DashboardData(coursesDict[4]?:default_course,R.drawable.electric_circuit)


        //CALL ADAPTER TO DISPLAY COURSES

        val courseList: RecyclerView = findViewById<View>(R.id.courseList) as RecyclerView
        adapter = CustomAdapter(this,courseNames)
        courseList.adapter = adapter
        courseList.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

    }

    //Open the side menu when button pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}