package com.example.dbdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DisplayAllStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_all_student)

        var res_data = findViewById<RecyclerView>(R.id.res_data)
        res_data.layoutManager = LinearLayoutManager(DisplayAllStudent@this)

        var db_helper = DatabaseHelper(this)

        var res_studentList: MutableList<StudentModel> = ArrayList()
        res_studentList = db_helper.getAllData()

        var myAdapter = MyAdapter(DisplayAllStudent@this, res_studentList)
        res_data.adapter = myAdapter
    }
}