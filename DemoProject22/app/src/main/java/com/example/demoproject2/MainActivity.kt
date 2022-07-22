package com.example.demoproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    var mytablayout: TabLayout? = null
    var myviewpager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mytablayout = findViewById(R.id.mytablayout)
        myviewpager = findViewById(R.id.myviewpager)

//        mytablayout!!.addTab(mytablayout!!.newTab().setText("CHARTS"))
//        mytablayout!!.addTab(mytablayout!!.newTab().setText("STATUS"))

        mytablayout!!.tabGravity = TabLayout.GRAVITY_FILL

        setUoViewPager(myviewpager!!)
        mytablayout!!.setupWithViewPager(myviewpager)
    }

    fun setUoViewPager(viewPager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(FragmentCharts(), "CHARTS")
        adapter.addFragment(FragmentStatus(), "STATUS")

        viewPager.adapter = adapter
    }

    class ViewPagerAdapter: FragmentPagerAdapter{
        var fragmentList: ArrayList<Fragment> = ArrayList()
        var fragmentTitleList: ArrayList<String> = ArrayList()

        constructor(supportFragmentManager: FragmentManager): super(supportFragmentManager)

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList.get(position)
        }

        override fun getPageTitle(position: Int): String {
            return fragmentTitleList.get(position)
        }

        fun addFragment(fragment: Fragment, title: String){
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

    }
}