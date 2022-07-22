package com.example.demoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class ApplicationDrawer : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_drawer)

        var mytoolbar = findViewById<Toolbar>(R.id.mytoolbar)
        setSupportActionBar(mytoolbar)
        var drawerlayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        var navview = findViewById<NavigationView>(R.id.navview)
        var navController = findNavController(R.id.navhostfragment)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.profileFragment, R.id.settingsFragment), drawerlayout)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navview.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        var navController = findNavController(R.id.navhostfragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}