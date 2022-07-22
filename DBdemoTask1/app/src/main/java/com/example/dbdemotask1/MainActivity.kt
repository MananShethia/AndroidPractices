package com.example.dbdemotask1

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var main = findViewById<LinearLayout>(R.id.main)

        //fragment display on activity
        var fragmentManager = supportFragmentManager //import services
        var fragmentTransaction = fragmentManager.beginTransaction() //begin working with setup

        var transactionHistory = TransactionHistory() //instance of fragment class
        fragmentTransaction.add(R.id.main, transactionHistory).commit() //save changes of fragment onto the main activity

        var mainpay = findViewById<Button>(R.id.mainpay)
        var mainaccept = findViewById<Button>(R.id.mainaccept)
        var dbhelper = DatabaseHelper(this)

        mainpay.setOnClickListener {

            var d = Dialog(this)
            d.setContentView(R.layout.activity_pay_dialog)

            var tname = d.findViewById<EditText>(R.id.tname)
            var tmobile = d.findViewById<EditText>(R.id.tmobile)
            var tamount = d.findViewById<EditText>(R.id.tamount)
            var tdate = d.findViewById<EditText>(R.id.tdate)
            var pay_btn = d.findViewById<AppCompatButton>(R.id.pay_btn)

            d.show()

            pay_btn.setOnClickListener{
                var id = dbhelper.insertData(
                    TransactionModel(
                        it.id!!,
                        tname.text.toString(),
                        tmobile.text.toString(),
                        tamount.text.toString(),
                        tdate.text.toString(),
                        pay_btn.text.toString()
                    ))

                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        mainaccept.setOnClickListener {

            var d = Dialog(this)
            d.setContentView(R.layout.activity_accept_dialog)

            var tname_a = d.findViewById<EditText>(R.id.tname_a)
            var tmobile_a = d.findViewById<EditText>(R.id.tmobile_a)
            var tamount_a = d.findViewById<EditText>(R.id.tamount_a)
            var tdate_a = d.findViewById<EditText>(R.id.tdate_a)
            var accept_btn = d.findViewById<AppCompatButton>(R.id.accept_btn)

            d.show()

            accept_btn.setOnClickListener {
                var id = dbhelper.insertData(
                    TransactionModel(
                        it.id!!,
                        tname_a.text.toString(),
                        tmobile_a.text.toString(),
                        tamount_a.text.toString(),
                        tdate_a.text.toString(),
                        accept_btn.text.toString()
                    )
                )

                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
