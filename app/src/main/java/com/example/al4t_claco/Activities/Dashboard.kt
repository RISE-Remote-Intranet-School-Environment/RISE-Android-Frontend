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

        //CREATE ACTIVITIES AND COURSES
        // integrating view model
        val activityModel : DashboardViewModel by viewModels()

        val activitiesList = activityModel.get_all_activities()
        for (activity in activitiesList){
            if (activity.name==""){
                Log.i("Found ",activity.name + activity.code)
            }


        }
        //TODO : Get this from the API instead of creating them here


        val course = Course("GPU Computing","4inf",4,5,"Lur","This course deals with GPU Computing", activitiesList.slice(0..2))
        val course1 = Course("Database","4DB",4,5,"Lor","This course deals with database", activitiesList.slice(2..4))
        val course2 = Course("APPS","4app",4,5,"LRK","This course deals with APPS", activitiesList.slice(1..3))
        val course3 = Course("Electronics","4el",4,5,"MCH","This course deals with electronics", activitiesList.slice(3..5))
        val course4 = Course("Electricity","4inf",4,5,"CMS","This course deals with electricity", activitiesList.slice(1..4))

        val course_logo = DashboardData(course,R.drawable.ic_launcher_foreground)
        val course_logo1 = DashboardData(course1,R.drawable.ic_launcher_foreground)
        val course_logo2 = DashboardData(course2,R.drawable.ic_launcher_foreground)
        val course_logo3 = DashboardData(course3,R.drawable.ic_launcher_foreground)
        val course_logo4 = DashboardData(course4,R.drawable.electric_circuit)

        val courseNames = listOf<DashboardData>(course_logo,course_logo1,course_logo2,course_logo3,course_logo4)

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