package com.example.dbdemotask1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TransactionHistory : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_transaction_history, container, false)
        var res_data = v.findViewById<RecyclerView>(R.id.res_data)

        res_data.layoutManager = LinearLayoutManager(container!!.context, LinearLayoutManager.VERTICAL, true)

        var db_helper = DatabaseHelper(container!!.context)

//        db_helper.deleteTable()
//        Toast.makeText(container!!.context, "DELETED", Toast.LENGTH_LONG).show()

        var res_transactionList: MutableList<TransactionModel> = ArrayList()
        res_transactionList = db_helper.getAllData()

//        var transactionAdapter = TransactionAdapter(container!!.context, res_transactionList)
//        res_data.adapter = transactionAdapter

        return v
    }
}