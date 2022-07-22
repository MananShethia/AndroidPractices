package com.example.dbdemo1

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat.startActivity
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

        var rl_edit = view.findViewById<Button>(R.id.rl_edit)
        var rl_delete = view.findViewById<Button>(R.id.rl_delete)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {
        var mydata = studentList[position]
//        Log.d("mydata", mydata.student_name)
        holder.res_name.text = mydata.student_name
        holder.res_email.text = mydata.student_email
        holder.res_mobile.text = mydata.student_mobile

        holder.rl_edit.setOnClickListener {
            var d = Dialog(context)
            d.setContentView(R.layout.mydialog)

            var ed_student_name = d.findViewById<EditText>(R.id.regname_u)
            var ed_student_email = d.findViewById<EditText>(R.id.regemail_u)
            var ed_student_password = d.findViewById<EditText>(R.id.regpassword_u)
            var ed_student_mobile = d.findViewById<EditText>(R.id.regmobile_u)
            var update_btn = d.findViewById<AppCompatButton>(R.id.update_btn)

            ed_student_name.setText(mydata.student_name)
            ed_student_email.setText(mydata.student_email)
            ed_student_password.setText(mydata.student_password)
            ed_student_mobile.setText(mydata.student_mobile)

            d.show()

            update_btn.setOnClickListener{
                var sm = StudentModel(mydata.student_id,
                                      ed_student_name.text.toString(),
                                      ed_student_email.text.toString(),
                                      ed_student_password.text.toString(),
                                      ed_student_mobile.text.toString()
                                     )

                var id = DatabaseHelper(context).updateData(sm)

                var intent = Intent(context, DisplayAllStudent::class.java)
                context.startActivity(intent)
            }
        }
        holder.rl_delete.setOnClickListener {
            var alertDialog = AlertDialog.Builder(context)
                .setTitle("Delete Student")
                .setMessage("Are you sure you want to delete data")
                .setPositiveButton("Yes", DialogInterface.OnClickListener{ dialogInterface, i ->
                    var db = DatabaseHelper(context)
                    var sm = StudentModel(mydata.student_id, "","","","")
                    var id = db.deleteData(sm)

                    var intent = Intent(context, DisplayAllStudent::class.java)
                    context.startActivity(intent)

                    dialogInterface.dismiss()
                })
                .setNegativeButton("No", DialogInterface.OnClickListener{ dialogInterface, i ->
                    dialogInterface.dismiss()
                })
                .show()
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}