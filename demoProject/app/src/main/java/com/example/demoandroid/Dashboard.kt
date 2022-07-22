package com.example.demoandroid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

//        var intent = getIntent().extras
//        Log.d("mydata", "email : " + intent!!.getString("keyEmail"))
//        Log.d("mydata", "password : " + intent!!.getString("keyPassword"))








//        var dashboardBtn = findViewById<Button>(R.id.dashboardBtn)
//        var dashboardPage = findViewById<LinearLayout>(R.id.dashboardPage)
//
//        val layout = layoutInflater.inflate(R.layout.custom_toast, dashboardPage)
//
//        dashboardBtn.setOnClickListener {
//            var toast = Toast(applicationContext)
//            toast.duration = Toast.LENGTH_SHORT
//            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
//            toast.view = layout
//            toast.show()
//        }





        var layout = findViewById<LinearLayout>(R.id.dashboardPage)
        var textview = TextView(this)

        textview.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textview.text = "Welcome dynamic toast"
        textview.setTextSize(20f)
        textview.setTextColor(Color.BLUE)

        layout.addView(textview)

    }
}