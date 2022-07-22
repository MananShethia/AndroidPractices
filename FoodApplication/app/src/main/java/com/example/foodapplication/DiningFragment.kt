package com.example.foodapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DiningFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_dining, container, false)

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
        rdata.layoutManager = LinearLayoutManager(context)

        val ral = ArrayList<DoPlacesModels>()
        ral.add(DoPlacesModels(R.mipmap.dop1, "Confit", "24 mins ● 2 km", "200 for one", "3.6"))
        ral.add(DoPlacesModels(R.mipmap.dop2, "Tartare", "45 mins ● 1.5 km", "500 for two", "2.6"))
        ral.add(DoPlacesModels(R.mipmap.dop3, "Amuse-Bouche", "30 mins ● 3 km", "150 for one", "1.6"))
        ral.add(DoPlacesModels(R.mipmap.dop4, "Chiffonade", "10 mins ● 700 m", "700 for four", "4.6"))
        ral.add(DoPlacesModels(R.mipmap.dop5, "Sous vide", "1 hr ● 3.8 km", "300 for one", "3.8"))

        var doplacesAdapter = DoPlacesAdapter(ral)
        rdata.adapter = doplacesAdapter



//        FOOD CATEGORY
        var cdata = v.findViewById<RecyclerView>(R.id.cdata)
        cdata.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val cal = ArrayList<DoCollectionsModels>()
        cal.add(DoCollectionsModels(R.mipmap.doc1, "Newly Opened"))
        cal.add(DoCollectionsModels(R.mipmap.doc2, "Best Of Ahmedabad"))
        cal.add(DoCollectionsModels(R.mipmap.doc3, "Trending This week"))
        cal.add(DoCollectionsModels(R.mipmap.doc4, "Best Pizza Places"))
        cal.add(DoCollectionsModels(R.mipmap.doc5, "Great Cafe"))
        cal.add(DoCollectionsModels(R.mipmap.doc6, "Work Friendly"))
        cal.add(DoCollectionsModels(R.mipmap.doc7, "Rooftop"))
        cal.add(DoCollectionsModels(R.mipmap.doc8, "Live Sports Screenings"))

        var doCollectionsAdapter = DoCollectionsAdapter(cal)
        cdata.adapter = doCollectionsAdapter

        return v
    }
}