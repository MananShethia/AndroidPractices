package com.example.foodapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionAdapter(var myarrayList: List<OptionModels>): RecyclerView.Adapter<OptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_optiondata, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionAdapter.ViewHolder, position: Int) {
        val optionModels = myarrayList[position]
        holder.optionname.setText(optionModels.optionName)
    }

    override fun getItemCount(): Int {
        return myarrayList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var optionname = itemView.findViewById<TextView>(R.id.optionname)
    }
}