package com.example.dbdemo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var regname: TextInputLayout
        lateinit var regemail: TextInputLayout
        lateinit var regpassword: TextInputLayout
        lateinit var regmobile: TextInputLayout
        lateinit var regsubmit: AppCompatButton
        lateinit var mainpage: LinearLayout
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



        //INSERT LOGIC
        var dbhelper = DatabaseHelper(this)
        regsubmit.setOnClickListener {
            var name = regname.editText?.text.toString()
            var email = regemail.editText?.text.toString()
            var password = regpassword.editText?.text.toString()
            var mobile = regmobile.editText?.text.toString()

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
        }

    }
}