package com.android.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.android.recyclerviewapp.adapter.EventAdapter
import com.android.recyclerviewapp.views.FirstFragment
import com.android.recyclerviewapp.views.SecondFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentNavigation(supportFragmentManager, FirstFragment.newInstance())
    }
}