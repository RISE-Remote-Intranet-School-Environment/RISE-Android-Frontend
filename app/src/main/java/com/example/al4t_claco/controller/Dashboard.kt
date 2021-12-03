 package com.example.al4t_claco.controller

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.al4t_claco.LoginActivity
import com.example.al4t_claco.R
import com.example.al4t_claco.model.Activity
import com.example.al4t_claco.model.Course
import com.example.al4t_claco.model.File
import com.google.android.material.navigation.NavigationView

 class Dashboard  : AppCompatActivity() {
    var adapter: CustomAdapter? =null
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val courseList: RecyclerView = findViewById<View>(R.id.courseList) as RecyclerView
        val drawerLayout : DrawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val navView : NavigationView = findViewById<View>(R.id.navView) as NavigationView

        val courseImages = ArrayList<Int>()

        val matricule = intent.getStringExtra("matricule")
        val headerView = navView.getHeaderView(0)
        val user = headerView.findViewById<TextView>(R.id.user)
        user.text = matricule



        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> startActivity(Intent(this, Dashboard::class.java))
                R.id.nav_calendar -> Toast.makeText(applicationContext,"Clicked Calendar", Toast.LENGTH_SHORT).show()
                R.id.nav_forum -> Toast.makeText(applicationContext,"Clicked Forum", Toast.LENGTH_SHORT).show()
                R.id.password -> Toast.makeText(applicationContext,"Change password",Toast.LENGTH_SHORT).show()
                R.id.logout -> startActivity(Intent(this, LoginActivity::class.java))
            }
            false
        }

        //TODO : Bouger ca autre part mais pas ultra important pour le moment

        val activity = Activity("Info","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity2 = Activity("Bidule","4inf", listOf("Lorge","Lurkin","Dekimpe"))
        val activity3 = Activity("Truc","4inf", listOf("Lorge","Lurkin","Dekimpe"))

        activity.resources = listOf(File("file 1","pdf"), File("file 2","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity2.resources = listOf(File("file 1","pdf"), File("file 2","pdf"), File("file 3","pdf"), File("file 4","PDF"))
        activity3.resources = listOf(File("file 5","pdf"), File("file 6","pdf"), File("file 3","pdf"), File("file 4","PDF"))

        val activityList = listOf<Activity>(activity,activity2,activity3)

        val course = Course("Info","4inf",4,5,"Lur", activityList,R.drawable.ic_launcher_foreground)
        val course1 = Course("Database","4DB",4,5,"Lor", activityList,R.drawable.ic_launcher_foreground)
        val course2 = Course("APPS","4app",4,5,"LRK", activityList,R.drawable.ic_launcher_foreground)
        val course3 = Course("Electronics","4el",4,5,"MCH", activityList,R.drawable.ic_launcher_foreground)
        val course4 = Course("Electricity","4inf",4,5,"CMS", activityList,R.drawable.electric_circuit)

        val courseNames = listOf<Course>(course,course1,course2,course3,course4);

        adapter = CustomAdapter(this,courseNames)
        courseList.adapter = adapter
        courseList.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

        //courseList.adapter = Adapter(this,courseNames,courseImages);
        //courseList.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        //val adapter = Adapter(this, CourseNames, CourseImages);
        //val gridLayoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        //courseList.layoutManager = gridLayoutManager;

    }

     fun OnCreateOptionsMenu(menu: ContextMenu?) : Boolean {
        menuInflater.inflate(R.menu.side_menu,menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}