package com.example.interndemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("mydata : ", "on create")

    }

    override fun onStart() {
        super.onStart()
        Log.d("mydata : ", "on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mydata : ", "on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mydata : ", "on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mydata : ", "on stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mydata : ", "on restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mydata : ", "on destroy")
    }
}
