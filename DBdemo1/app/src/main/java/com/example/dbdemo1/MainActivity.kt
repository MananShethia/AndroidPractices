package com.example.dbdemo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var regname: EditText
        lateinit var regemail: EditText
        lateinit var regpassword: EditText
        lateinit var regmobile: EditText
        lateinit var regsubmit: AppCompatButton
        lateinit var mainpage: LinearLayout

//        lateinit var loginemail: EditText
//        lateinit var loginpassword: EditText
//        lateinit var loginsubmit: AppCompatButton
//        lateinit var loginpage: LinearLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        regname = findViewById(R.id.regname)
        regemail = findViewById(R.id.regemail)
        regpassword = findViewById(R.id.regpassword)
        regmobile = findViewById(R.id.regmobile)
        regsubmit = findViewById(R.id.regsubmit)
        mainpage = findViewById(R.id.mainpage)

//        loginemail = findViewById(R.id.loginemail)
//        loginpassword = findViewById(R.id.loginpassword)
//        loginsubmit = findViewById(R.id.loginsubmit)


        //INSERT LOGIC
        var dbhelper = DatabaseHelper(this)
        regsubmit.setOnClickListener {

            var name = regname.text.toString()
            var email = regemail.text.toString()
            var password = regpassword.text.toString()
            var mobile = regmobile.text.toString()

            var show_btn = findViewById<FloatingActionButton>(R.id.show_btn)

            var id = dbhelper.insertData(StudentModel(it.id!!, name, email, password, mobile))
            if(id > 0) {
                Snackbar.make(mainpage, "Data inserted successfully", Snackbar.LENGTH_LONG).show()
//                Toast.makeText(this@MainActivity, "Data inserted successfully", Toast.LENGTH_LONG).show()

                var intent = Intent(MainActivity@this, DisplayAllStudent::class.java)
                startActivity(intent)
            }
            else {
                Snackbar.make(mainpage, "Somting went wrong, data not inserted", Snackbar.LENGTH_LONG).show()
//                Toast.makeText(this@MainActivity, "Somting went wrong, data not inserted", Toast.LENGTH_LONG).show()
            }

            show_btn.setOnClickListener{
                var intent = Intent(MainActivity@this, DisplayAllStudent::class.java)
                startActivity(intent)
            }
        }
    }
}