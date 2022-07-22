package com.example.demoproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btmnv = findViewById<BottomNavigationView>(R.id.btmnv)
        loadFragment(HomeFragment())

        btmnv.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ophome -> {
                    loadFragment(HomeFragment())
                }
                R.id.opprofile -> {
                    loadFragment(ProfileFragment())
                }
                R.id.opsettings -> {
                    loadFragment(SettingsFragment())
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }

    fun loadFragment(frag: Fragment){
        var fragTranction = supportFragmentManager.beginTransaction()
        fragTranction.replace(R.id.mainpage, frag)
        fragTranction.addToBackStack(null) // disable back button activity
        fragTranction.commit()
    }

}