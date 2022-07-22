package com.example.foodapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(var myarrayList: List<FoodModels>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        val foodModels = myarrayList[position]
        holder.rd_img.setImageResource(foodModels.foodImage)
        holder.rd_txt.setText(foodModels.foodName)
        holder.rating.setText(foodModels.foodRating)
        holder.info.setText(foodModels.foodInfo)
        holder.price.setText(foodModels.foodPrice)
        holder.discount.setText(foodModels.foodDiscount)
    }

    override fun getItemCount(): Int {
        return myarrayList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var rd_img = itemView.findViewById<ImageView>(R.id.rd_img)
        var rd_txt = itemView.findViewById<TextView>(R.id.rd_txt)
        var rating = itemView.findViewById<TextView>(R.id.rating)
        var info = itemView.findViewById<TextView>(R.id.info)
        var price = itemView.findViewById<TextView>(R.id.price)
        var discount = itemView.findViewById<TextView>(R.id.discount)
    }
}