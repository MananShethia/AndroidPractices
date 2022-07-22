package com.example.foodapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DeliveryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_delivery, container, false)

        var v = inflater.inflate(R.layout.fragment_delivery, container, false)

        // OPTION
        var optiondata = v.findViewById<RecyclerView>(R.id.optiondata)
        optiondata.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val opal = ArrayList<OptionModels>()
        opal.add(OptionModels("Home"))
        opal.add(OptionModels("Shops"))
        opal.add(OptionModels("Category"))
        opal.add(OptionModels("Search"))

        var optionAdapter = OptionAdapter(opal)
        optiondata.adapter = optionAdapter



//        FOOD NAME
        var rdata = v.findViewById<RecyclerView>(R.id.rdata)
        rdata.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val ral = ArrayList<FoodModels>()
        ral.add(FoodModels(R.mipmap.f1, "Confit", "24 mins ● 2 km", "200 for one", "3.6", "50% OFF"))
        ral.add(FoodModels(R.mipmap.f2, "Tartare", "45 mins ● 1.5 km", "500 for two", "2.6", "20% OFF"))
        ral.add(FoodModels(R.mipmap.f3, "Amuse-Bouche", "30 mins ● 3 km", "150 for one", "1.6", "35% OFF"))
        ral.add(FoodModels(R.mipmap.f4, "Chiffonade", "10 mins ● 700 m", "700 for four", "4.6", "10% OFF"))
        ral.add(FoodModels(R.mipmap.f5, "Sous vide", "1 hr ● 3.8 km", "300 for one", "3.8", "45% OFF"))

        var foodAdapter1 = FoodAdapter(ral)
        rdata.adapter = foodAdapter1



//        FOOD CATEGORY
        var cdata = v.findViewById<RecyclerView>(R.id.cdata)
        cdata.layoutManager = GridLayoutManager(context, 4)

        val cal = ArrayList<CategoryModels>()
        cal.add(CategoryModels(R.mipmap.c1, "Home Style"))
        cal.add(CategoryModels(R.mipmap.c2, "Pizza"))
        cal.add(CategoryModels(R.mipmap.c3, "Sandwich"))
        cal.add(CategoryModels(R.mipmap.c4, "Chaat"))
        cal.add(CategoryModels(R.mipmap.c5, "Burger"))
        cal.add(CategoryModels(R.mipmap.c6, "Vada"))
        cal.add(CategoryModels(R.mipmap.c7, "Rolls"))
        cal.add(CategoryModels(R.mipmap.c8, "Shake"))
        cal.add(CategoryModels(R.mipmap.c9, "Vada Pav"))
        cal.add(CategoryModels(R.mipmap.c10, "Fries"))
        cal.add(CategoryModels(R.mipmap.c11, "Samosa"))
        cal.add(CategoryModels(R.mipmap.c12, "Wraps"))

        var categoryAdapter = CategoryAdapter(cal)
        cdata.adapter = categoryAdapter

        return v
    }

}