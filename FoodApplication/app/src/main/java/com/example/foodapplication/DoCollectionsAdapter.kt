package com.example.foodapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoCollectionsAdapter(var myarrayList: List<DoCollectionsModels>): RecyclerView.Adapter<DoCollectionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoCollectionsAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_docollections, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoCollectionsAdapter.ViewHolder, position: Int) {
        val doCollectionsModels = myarrayList[position]
        holder.doc_img.setImageResource(doCollectionsModels.docollectionsImg)
        holder.doc_name.setText(doCollectionsModels.docollectionsName)
    }

    override fun getItemCount(): Int {
        return myarrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var doc_img = itemView.findViewById<ImageView>(R.id.doc_img)
        var doc_name = itemView.findViewById<TextView>(R.id.doc_name)
    }
}