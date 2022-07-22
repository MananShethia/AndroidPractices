package com.example.dbdemotask1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(var context: Context, var transactionList:MutableList<TransactionModel>): RecyclerView.Adapter<TransactionAdapter.MyClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass {
        var view = LayoutInflater.from(context).inflate(R.layout.row_transaction_data, parent, false)
        return MyClass(view)
    }

    class MyClass(view: View): RecyclerView.ViewHolder(view){

        var transactionmname = view.findViewById<TextView>(R.id.transactionmname)
        var transactionamount = view.findViewById<TextView>(R.id.transactionamount)
        var transactiondate = view.findViewById<TextView>(R.id.transactiondate)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {

        var mydata = transactionList[position]
        holder.transactionmname.text = mydata.transaction_name
        holder.transactionamount.text = mydata.transaction_amount
        holder.transactiondate.text = mydata.transaction_date

        if(mydata.transaction_type == "ACCEPT") {
            holder.transactionamount.setTextColor(Color.GREEN)
        }
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }
}