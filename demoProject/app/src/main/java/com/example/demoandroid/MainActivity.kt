package com.example.demoandroid

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var text1 = findViewById<TextView>(R.id.text1)
//        text1.setOnClickListener {
////            Toast.makeText(this, "Welcome android user", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@MainActivity, "Value = " + text1.text.toString(), Toast.LENGTH_SHORT).show()
//        }
//        var btn_submit = findViewById<Button>(R.id.btn_submit)
//        btn_submit.setOnClickListener {
//            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
//        }




//        var android = findViewById<Button>(R.id.android)
//        var kotlin = findViewById<Button>(R.id.kotlin)
//        android.setOnClickListener {
//            text1.text=android.text.toString()
//            android.setBackgroundColor(resources.getColor(R.color.teal_700))
//            kotlin.setBackgroundColor(resources.getColor(R.color.purple_700))
//        }
//        kotlin.setOnClickListener {
//            text1.text=kotlin.text.toString()
//            kotlin.setBackgroundColor(resources.getColor(R.color.teal_700))
//            android.setBackgroundColor(resources.getColor(R.color.purple_700))
//        }



//        var mainpage = findViewById<LinearLayout>(R.id.mainpage)
//        var red = findViewById<Button>(R.id.red)
//        var green = findViewById<Button>(R.id.green)
//        var blue = findViewById<Button>(R.id.blue)
//        red.setOnClickListener {
//            mainpage.setBackgroundColor(resources.getColor(R.color.red))
//        }
//        green.setOnClickListener {
//            mainpage.setBackgroundColor(resources.getColor(R.color.green))
//        }
//        blue.setOnClickListener {
//            mainpage.setBackgroundColor(resources.getColor(R.color.blue))
//        }





//        var email = findViewById<EditText>(R.id.email)
//        var password = findViewById<EditText>(R.id.password)
//        var loginbtn = findViewById<Button>(R.id.loginbtn)
//        var bool:Boolean = false
//        loginbtn.setOnClickListener {
////            Toast.makeText(this, "Email : " + email.text.toString(), Toast.LENGTH_SHORT).show()
////            Toast.makeText(this, "Password : " + password.text.toString(), Toast.LENGTH_SHORT).show()
//            Log.d("MyData : ", "email = " + email.text.toString() + "Password = " + password.text.toString())
//        }

//        loginbtn.setOnClickListener {
//            if(!bool)
//            {
//                text1.text="ON"
//
//            }
//            else{
//                text1.text="OFF"
//            }
//            bool = !bool
//        }







//        var btnnext = findViewById<Button>(R.id.btnnext)
//
//        btnnext.setOnClickListener {
//            var intent = Intent(this@MainActivity, SecondPage::class.java)
//            startActivity(intent)
//            finish() // destroy current screen
//        }
//
//        btnnext.setOnClickListener {
//            var intent = Intent(Intent.ACTION_VIEW)
//            intent.setData(Uri.parse("https://www.google.com"))
//            startActivity(intent)
//            finish() // destroy current screen
//        }







//        var rg = findViewById<RadioGroup>(R.id.rg)
//        rg.setOnCheckedChangeListener { radioGroup, id ->
//            if( id == R.id.rb_android ){
//                Toast.makeText(this, "ANDROID", Toast.LENGTH_SHORT).show()
//            }
//            if( id == R.id.rb_java ){
//                Toast.makeText(this, "JAVA", Toast.LENGTH_SHORT).show()
//            }
//            if( id == R.id.rb_python ){
//                Toast.makeText(this, "PYTHON", Toast.LENGTH_SHORT).show()
//            }
//        }







//        var rg = findViewById<RadioGroup>(R.id.rg)
//        var btnnext = findViewById<Button>(R.id.btnnext)
//        var valueradio:String? = null
//        rg.setOnCheckedChangeListener { radioGroup, id ->
//            if( id == R.id.rb_android ){
//                valueradio = "Android"
//            }
//            if( id == R.id.rb_java ){
//                valueradio = "Java"
//            }
//            if( id == R.id.rb_python ){
//                valueradio = "Android"
//            }
//        }
//
//        btnnext.setOnClickListener {
//            Toast.makeText(this, "button Value" + valueradio, Toast.LENGTH_SHORT).show()
//        }






//        var email = findViewById<EditText>(R.id.email)
//        var password = findViewById<EditText>(R.id.password)
//        var btn = findViewById<Button>(R.id.btn)
//
//        btn.setOnClickListener {
//            var intent = Intent(this@MainActivity, Dashboard::class.java)
//            intent.putExtra("keyEmail", email.text.toString())
//            intent.putExtra("keyPassword", password.text.toString())
//            startActivity(intent)
//            finish() // destroy current screen
//        }










//        var chk_c = findViewById<CheckBox>(R.id.chk_c)
//        var chk_java = findViewById<CheckBox>(R.id.chk_java)
//        var chk_py = findViewById<CheckBox>(R.id.chk_py)
//
//        chk_c.setOnCheckedChangeListener{ componentButton, b ->
//            if(b){
//                chk_c.setTextColor(resources.getColor(R.color.blue))
//                Toast.makeText(this, ""+chk_c.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//        }
//        chk_java.setOnCheckedChangeListener{ componentButton, b ->
//            if(b){
//                Toast.makeText(this, ""+chk_java.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//        }
//        chk_py.setOnCheckedChangeListener{ componentButton, b ->
//            if(b){
//                Toast.makeText(this, ""+chk_py.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//        }








//        var check_array = arrayListOf<String>()
//
//        var chk_c = findViewById<CheckBox>(R.id.chk_c)
//        var chk_java = findViewById<CheckBox>(R.id.chk_java)
//        var chk_py = findViewById<CheckBox>(R.id.chk_py)
//
//        chk_c.setOnCheckedChangeListener{ componentButton, b ->
//            if(b){
//                check_array.add(chk_c.text.toString())
//                Toast.makeText(this, "Added : "+chk_c.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//            else{
//                check_array.remove(chk_c.text.toString())
//                Toast.makeText(this, "Removed : "+chk_c.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//            Log.d("mydata", check_array.toString())
//        }
//        chk_java.setOnCheckedChangeListener{ componentButton, b ->
//            if(b){
//                check_array.add(chk_java.text.toString())
//                Toast.makeText(this, "Added : "+chk_java.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//            else{
//                check_array.remove(chk_java.text.toString())
//                Toast.makeText(this, "Removed : "+chk_c.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//            Log.d("mydata", check_array.toString())
//        }
//        chk_py.setOnCheckedChangeListener{ componentButton, b ->
//            if(b){
//                check_array.add(chk_py.text.toString())
//                Toast.makeText(this, "Added : "+chk_py.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//            else{
//                check_array.remove(chk_py.text.toString())
//                Toast.makeText(this, "Removed : "+chk_c.text.toString(), Toast.LENGTH_SHORT).show()
//            }
//            Log.d("mydata", check_array.toString())
//        }









//        var fabtn = findViewById<FloatingActionButton>(R.id.fabtn)
//        fabtn.setOnClickListener {
//            var intent = Intent(this@MainActivity, SecondPage::class.java)
//            startActivity(intent)
//            finish() // destroy current screen
//        }
//
////        fabtn.setOnClickListener {
////            var intent = Intent(Intent.ACTION_VIEW)
////            intent.setData(Uri.parse("https://www.google.com"))
////            startActivity(intent)
////            finish() // destroy current screen
////        }












//        var lvdata = findViewById<ListView>(R.id.lvdata)
//
//        lvdata.setOnItemClickListener { adapterView, view, position, id ->
////            Toast.makeText(this@MainActivity, "" + adapterView.get(position), Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@MainActivity, "" + lvdata.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
//        }





//        // AdapterView
//        var lvdata = findViewById<ListView>(R.id.lvdata)
//
//        // Array
//        var programming_language = arrayOf("C", "C++", "Java", "Python", "PHP", "Kotlin", "React")
//
//        // declare adapter with the type of ArrayAdapter which accept all type of data
//        var adapter : ArrayAdapter<*>
//        adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, programming_language)
//        lvdata.adapter = adapter










//        var ldata = arrayListOf<String>()
//        var adapter : ArrayAdapter<*>
//
//        var lvdata = findViewById<ListView>(R.id.lvdata)
//        var ldata_text = findViewById<EditText>(R.id.ldata_text)
//        var ldata_btn = findViewById<Button>(R.id.ldata_btn)
//
//        ldata_btn.setOnClickListener {
//            ldata.add(ldata_text.text.toString())
//            ldata_text.text.clear()
//            adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, ldata)
//            lvdata.adapter = adapter
//        }
//
//        lvdata.setOnItemClickListener { adapterView, view, position, id ->
//            Toast.makeText(applicationContext, "" + lvdata.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
//        }
//
//        lvdata.setOnItemLongClickListener { adapterView, view, position, id ->
//            ldata.remove(lvdata.getItemAtPosition(position))
//            adapter.notifyDataSetChanged()
//        }











//        var spdata = findViewById<Spinner>(R.id.spdata)
//
//        spdata.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(applicationContext, "" + spdata.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//        }










//        var alert_btn = findViewById<Button>(R.id.alert_btn)
//
//        alert_btn.setOnClickListener {
//            var builder = AlertDialog.Builder(this)
//                .setTitle("Alert Title")
//                .setMessage("Are you sure you want to exit")
//                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
//                    Toast.makeText(applicationContext, "YES", Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                })
//                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
//                    Toast.makeText(applicationContext, "NO", Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                })
//                .setNeutralButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
//                    Toast.makeText(applicationContext, "CANCEL", Toast.LENGTH_SHORT).show()
//                    dialog.cancel()
//                })
//                .setCancelable(false)
//            builder.show()
//        }










//        POPUP MENU
//        var popup_menu_btn = findViewById<Button>(R.id.popup_menu_btn)
//        var popupmenu = PopupMenu(applicationContext, popup_menu_btn)
//
//        popupmenu.menuInflater.inflate(R.menu.mymenu, popupmenu.menu)
//
//        popup_menu_btn.setOnClickListener {
//            popupmenu.show()
//        }
//
//        popupmenu.setOnMenuItemClickListener {
//            if(it.itemId == R.id.op_profile) {
//                Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
//            }
//            else if(it.itemId == R.id.op_about) {
//                Toast.makeText(applicationContext, "About", Toast.LENGTH_SHORT).show()
//            }
//            else if(it.itemId == R.id.op_settings) {
//                Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
//            }
//            else if(it.itemId == R.id.op_search) {
//                Toast.makeText(applicationContext, "Search", Toast.LENGTH_SHORT).show()
//                var intent = Intent(this@MainActivity, Dashboard::class.java)
//                startActivity(intent)
//            }
//            true
//        }












//        var calender = Calendar.getInstance()
//        var year = calender.get(Calendar.YEAR)
//        var month = calender.get(Calendar.MONTH)
//        var day = calender.get(Calendar.DAY_OF_MONTH)
//
//        var date_btn = findViewById<Button>(R.id.date_btn)
//
//        date_btn.setOnClickListener {
//            var today_date = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//                var m = month + 1
//                date_btn.text = "" + dayOfMonth + " - " + m + " - " + year
//            }, year, month, day)
//
////            today_date.getDatePicker().setMaxDate(Date().getTime())
//            today_date.getDatePicker().setMinDate(Date().getTime())
//            today_date.show()
//        }












//        var dialog_btn = findViewById<Button>(R.id.dialog_btn)
//        var uname_display = findViewById<TextView>(R.id.uname_display)
//        dialog_btn.setOnClickListener {
//            var d = Dialog(this@MainActivity)
////            d.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            d.setContentView(R.layout.custom_layout)
//            d.setCancelable(false)
//            d.show()
//
//            var uname = d.findViewById<EditText>(R.id.uname)
//            var btn = d.findViewById<Button>(R.id.btn)
//
//            btn.setOnClickListener {
//                uname_display.setText(uname.text.toString())
//                d.dismiss()
//            }
//        }











//        var btn = findViewById<Button>(R.id.btn)
//
//        btn.setOnClickListener {
//            var builder = AlertDialog.Builder(this@MainActivity)
//            builder.setTitle("Choose Your Programming Language")
//
//            var programming_language = arrayOf("C", "C++", "Java", "Python", "PHP")
//
//            builder.setItems(programming_language, DialogInterface.OnClickListener { dialog, which ->
//                when(which){
//                    0 -> Toast.makeText(this, "C Language", Toast.LENGTH_SHORT).show()
//                    1 -> Toast.makeText(this, "C++ Language", Toast.LENGTH_SHORT).show()
//                    2 -> Toast.makeText(this, "Java Language", Toast.LENGTH_SHORT).show()
//                    3 -> Toast.makeText(this, "Python Language", Toast.LENGTH_SHORT).show()
//                    4 -> Toast.makeText(this, "PHP Language", Toast.LENGTH_SHORT).show()
//                }
//            })
//
//            // CREATE AND SHOW THE ALERT BOX
//            var d = builder.create()
//            d.show()
//        }











//        var btn = findViewById<Button>(R.id.btn)
//
//        btn.setOnClickListener {
//            var builder = AlertDialog.Builder(this@MainActivity)
//            builder.setTitle("Choose Your Programming Language")
//
//            var programming_language = arrayOf("C", "C++", "Java", "Python", "PHP")
//
//            builder.setSingleChoiceItems(programming_language, 4, DialogInterface.OnClickListener { dialog, which ->
//                Toast.makeText(this@MainActivity, "" + programming_language[which], Toast.LENGTH_SHORT).show()
//            })
//
//            // CREATE AND SHOW THE ALERT BOX
//            var d = builder.create()
//            d.show()
//        }











//        var btn = findViewById<Button>(R.id.btn)
//
//        btn.setOnClickListener {
//            var builder = AlertDialog.Builder(this@MainActivity)
//            builder.setTitle("Choose Your Programming Language")
//
//            var programming_language = arrayOf("C", "C++", "Java", "Python", "PHP")
//
//            builder.setSingleChoiceItems(programming_language, 4, DialogInterface.OnClickListener { dialog, which ->
//                Toast.makeText(this@MainActivity, "" + programming_language[which], Toast.LENGTH_SHORT).show()
//            })
//
//            builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
//                dialog.dismiss()
//            })
//            builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
//                dialog.dismiss()
//            })
//
//            // CREATE AND SHOW THE ALERT BOX
//            var d = builder.create()
//            d.show()
//        }













        var btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Choose Your Programming Language")

            var programming_language = arrayOf("C", "C++", "Java", "Python", "PHP")

            var selectedChoice = arrayListOf<String>()
            builder.setMultiChoiceItems(programming_language, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                if(isChecked){
                    selectedChoice.add(programming_language[which])
                }
                else{
                    selectedChoice.remove(programming_language[which])
                }
            })

            builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                Log.d("mydata", selectedChoice.toString())
                dialog.dismiss()
            })
            builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })

            // CREATE AND SHOW THE ALERT BOX
            var d = builder.create()
            d.show()
        }
    }

    override fun onBackPressed() {
//        super.onBackPressed() // INTERRUPT IN ALERT CODE EXECUTION
        Toast.makeText(this, "Back Pressed", Toast.LENGTH_SHORT).show()

        var builder = AlertDialog.Builder(this)
            .setTitle("Alert Title")
            .setMessage("Are you sure you want to exit")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "YES", Toast.LENGTH_SHORT).show()
                finish() // ACTIVITY DESTROY
//                dialog.dismiss()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "NO", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })
            .setNeutralButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "CANCEL", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            })
            .setCancelable(false)
            .show()
    }


//    OPTION MENU
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.mymenu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.op_profile) {
//            Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
//        }
//        else if(item.itemId == R.id.op_about) {
//            Toast.makeText(applicationContext, "About", Toast.LENGTH_SHORT).show()
//        }
//        else if(item.itemId == R.id.op_settings) {
//            Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
//        }
//        else if(item.itemId == R.id.op_search) {
//            Toast.makeText(applicationContext, "Search", Toast.LENGTH_SHORT).show()
//            var intent = Intent(this@MainActivity, Dashboard::class.java)
//            startActivity(intent)
//        }
//        return super.onOptionsItemSelected(item)
//    }
}