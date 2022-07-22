package com.example.interndemo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentToActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_to_activity, container, false)
        var btn = v.findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            var i = Intent(activity, SecondActivity::class.java)
            startActivity(i)
        }
        return v
    }
}