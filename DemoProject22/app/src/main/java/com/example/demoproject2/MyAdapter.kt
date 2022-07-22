package com.example.demoproject2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManagerNonConfig
import androidx.fragment.app.FragmentPagerAdapter

//class MyAdapter(val context: Context, val fm:FragmentManager, internal var totaltabs:Int): FragmentPagerAdapter(fm) {
//    override fun getCount(): Int {
//        return totaltabs
//    }
//
////    call when we click on tab items
//    override fun getItem(position: Int): Fragment {
//        when(position){
//            0 -> {
//                return FragmentCharts()
//            }
//            1 -> {
//                return FragmentStatus()
//            }
//        }
//        return null
//    }
//}