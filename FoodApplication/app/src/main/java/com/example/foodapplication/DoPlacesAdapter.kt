package com.example.foodapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoPlacesAdapter(var myarrayList: List<DoPlacesModels>): RecyclerView.Adapter<DoPlacesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoPlacesAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_doplaces, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoPlacesAdapter.ViewHolder, position: Int) {
        val doPlacesAdapter = myarrayList[position]
        holder.rd_img.setImageResource(doPlacesAdapter.placesImage)
        holder.rd_txt.setText(doPlacesAdapter.placesName)
        holder.rating.setText(doPlacesAdapter.placesRating)
        holder.info.setText(doPlacesAdapter.placesInfo)
        holder.price.setText(doPlacesAdapter.placesPrice)
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
    }
}