package com.example.dbdemo2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var useremail = findViewById<TextView>(R.id.useremail)
        var logoutbtn = findViewById<Button>(R.id.logoutbtn)

        val custom_pref_file_name = "userdata"
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(custom_pref_file_name, Context.MODE_PRIVATE)

        var shared_value = sharedPreferences.getString("key_email", "default")
        useremail.text = "Welcome, " + shared_value

        logoutbtn.setOnClickListener {
            var editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()

            var intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}