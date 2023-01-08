package com.example.kakalogger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kakalogger.databinding.ActivityMainBinding
import com.example.kakalogger.ui.main.PlaceholderFragment
import com.example.kakalogger.ui.main.Viewpager2Adapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewpager2Adapter: Viewpager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(PlaceholderFragment.newInstance(1).layoutInflater)
//        setContentView(binding.root)
        tabLayout = binding.tabs
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = position.toString()
        }.attach()
    }
}