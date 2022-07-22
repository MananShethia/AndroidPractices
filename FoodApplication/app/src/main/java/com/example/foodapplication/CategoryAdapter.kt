package com.example.foodapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(var myarrayList: List<CategoryModels>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activity_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val categoryModels = myarrayList[position]
        holder.cat_img.setImageResource(categoryModels.categoryImg)
        holder.cat_name.setText(categoryModels.categoryName)
    }

    override fun getItemCount(): Int {
        return myarrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cat_img = itemView.findViewById<ImageView>(R.id.cat_img)
        var cat_name = itemView.findViewById<TextView>(R.id.cat_name)
    }
}