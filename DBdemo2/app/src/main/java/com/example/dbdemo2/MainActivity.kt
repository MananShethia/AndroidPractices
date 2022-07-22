package com.example.dbdemo2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val custom_pref_file_name = "userdata"

        var loginemail = findViewById<EditText>(R.id.loginemail)
        var loginpassword = findViewById<EditText>(R.id.loginpassword)
        var loginbtn = findViewById<Button>(R.id.loginbtn)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(custom_pref_file_name, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = sharedPreferences.edit()

        var key_status = sharedPreferences.getBoolean("key_status", false)
        if(key_status){
            var intent = Intent(this, Dashboard::class.java)
            finish()
            startActivity(intent)
        }

        loginbtn.setOnClickListener {
            editor.putString("key_email", loginemail.text.toString())
            editor.putString("key_password", loginpassword.text.toString())
//            editor.putString("key_status", "ture")
            editor.putBoolean("key_status", true)
            editor.apply()
            editor.commit()

            var intent = Intent(this, Dashboard::class.java)
            finish()
            startActivity(intent)
        }
    }
}