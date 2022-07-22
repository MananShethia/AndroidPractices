package com.example.foodapplication

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        setContentView(R.layout.fragment_delivery)

        var btmnv = findViewById<BottomNavigationView>(R.id.btmnv)
        var navController = findNavController(R.id.framentContainerView)
        btmnv.setupWithNavController(navController)











//        // OPTION
//        var optiondata = findViewById<RecyclerView>(R.id.optiondata)
//        optiondata.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//        val opal = ArrayList<OptionModels>()
//        opal.add(OptionModels("Home"))
//        opal.add(OptionModels("Shops"))
//        opal.add(OptionModels("Category"))
//        opal.add(OptionModels("Search"))
//
//        var optionAdapter = OptionAdapter(opal)
//        optiondata.adapter = optionAdapter
//
//
//
////        FOOD NAME
//        var rdata = findViewById<RecyclerView>(R.id.rdata)
//        rdata.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//        val ral = ArrayList<FoodModels>()
//        ral.add(FoodModels(R.mipmap.f1, "Confit", "24 mins ● 2 km", "200 for one", "3.6", "50% OFF"))
//        ral.add(FoodModels(R.mipmap.f2, "Tartare", "45 mins ● 1.5 km", "500 for two", "2.6", "20% OFF"))
//        ral.add(FoodModels(R.mipmap.f3, "Amuse-Bouche.\n", "30 mins ● 3 km", "150 for one", "1.6", "35% OFF"))
//        ral.add(FoodModels(R.mipmap.f4, "Chiffonade", "10 mins ● 700 m", "700 for four", "4.6", "10% OFF"))
//        ral.add(FoodModels(R.mipmap.f5, "Sous vide.\n", "1 hr ● 3.8 km", "300 for one", "3.8", "45% OFF"))
//
//        var foodAdapter1 = FoodAdapter(ral)
//        rdata.adapter = foodAdapter1
//
//
//
////        FOOD CATEGORY
//        var cdata = findViewById<RecyclerView>(R.id.cdata)
//        cdata.layoutManager = GridLayoutManager(this, 4)
//
//        val cal = ArrayList<CategoryModels>()
//        cal.add(CategoryModels(R.mipmap.c1, "Home Style"))
//        cal.add(CategoryModels(R.mipmap.c2, "Pizza"))
//        cal.add(CategoryModels(R.mipmap.c3, "Sandwich"))
//        cal.add(CategoryModels(R.mipmap.c4, "Chaat"))
//        cal.add(CategoryModels(R.mipmap.c5, "Burger"))
//        cal.add(CategoryModels(R.mipmap.c6, "Vada"))
//        cal.add(CategoryModels(R.mipmap.c7, "Rolls"))
//        cal.add(CategoryModels(R.mipmap.c8, "Shake"))
//        cal.add(CategoryModels(R.mipmap.c9, "Vada Pav"))
//        cal.add(CategoryModels(R.mipmap.c10, "Fries"))
//        cal.add(CategoryModels(R.mipmap.c11, "Samosa"))
//        cal.add(CategoryModels(R.mipmap.c12, "Wraps"))
//
//        var categoryAdapter = CategoryAdapter(cal)
//        cdata.adapter = categoryAdapter







//        var hotdeal = findViewById<RecyclerView>(R.id.hotdeal)
//        hotdeal.layoutManager = LinearLayoutManager(this)
//
//        val al1 = ArrayList<FoodModels>()
//        al1.add(FoodModels(R.mipmap.ic_launcher, "Android"))
//        al1.add(FoodModels(R.mipmap.meta_logo, "Meta"))
//
//        var foodAdapter1 = FoodAdapter(al1)
//        hotdeal.adapter = foodAdapter1
//
//
//
//        var mostview = findViewById<RecyclerView>(R.id.mostview)
//        mostview.layoutManager = LinearLayoutManager(this)
//
//        val al2 = ArrayList<FoodModels>()
//        al2.add(FoodModels(R.mipmap.ic_launcher, "Android"))
//        al2.add(FoodModels(R.mipmap.meta_logo, "Meta"))
//        al2.add(FoodModels(R.mipmap.meta_logo, "Meta"))
//
//        var foodAdapter2 = FoodAdapter(al2)
//        mostview.adapter = foodAdapter2
//
//
//
//        var category = findViewById<RecyclerView>(R.id.category)
//        category.layoutManager = GridLayoutManager(this, 4)
//
//        val al3 = ArrayList<FoodModels>()
//        al3.add(FoodModels(R.mipmap.ic_launcher, "Android"))
//        al3.add(FoodModels(R.mipmap.meta_logo, "Meta"))
//        al3.add(FoodModels(R.mipmap.ic_launcher, "Android"))
//        al3.add(FoodModels(R.mipmap.meta_logo, "Meta"))
//
//        var foodAdapter3 = FoodAdapter(al3)
//        category.adapter = foodAdapter3
    }

    override fun onBackPressed() {
        var builder = AlertDialog.Builder(this)
            .setTitle("OniFood Alert")
            .setMessage("Are you sure you want to exit")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "ThankYou For Staying", Toast.LENGTH_SHORT).show()
                finish()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            .setCancelable(false)

            builder.show()
    }
}