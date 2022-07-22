package com.example.dbdemo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DisplayAllStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_all_student)

        var res_data = findViewById<RecyclerView>(R.id.res_data)
        res_data.layoutManager = LinearLayoutManager(DisplayAllStudent@this)

        var add_btn = findViewById<FloatingActionButton>(R.id.add_btn)

        var db_helper = DatabaseHelper(this)

        var res_studentList: MutableList<StudentModel> = ArrayList()
        res_studentList = db_helper.getAllData()

        var myAdapter = MyAdapter(DisplayAllStudent@this, res_studentList)
        res_data.adapter = myAdapter


        add_btn.setOnClickListener{
            var intent = Intent(DisplayAllStudent@this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}