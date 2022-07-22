package com.example.dbdemo1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context:Context, var studentList:MutableList<StudentModel>): RecyclerView.Adapter<MyAdapter.MyClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass {
        var view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)
        return MyClass(view)
    }

    class MyClass(view: View): RecyclerView.ViewHolder(view){

        var res_name = view.findViewById<TextView>(R.id.res_name)
        var res_email = view.findViewById<TextView>(R.id.res_email)
        var res_mobile = view.findViewById<TextView>(R.id.res_mobile)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {
        var mydata = studentList[position]
        Log.d("mydata", mydata.student_name)
        holder.res_name.text = mydata.student_name
        holder.res_email.text = mydata.student_email
        holder.res_mobile.text = mydata.student_mobile
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}