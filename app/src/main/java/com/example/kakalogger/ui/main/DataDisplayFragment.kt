package com.example.kakalogger.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kakalogger.MainActivity.LogDaoSetup.logDao
import com.example.kakalogger.R
import com.example.kakalogger.ui.main.ScreenSlidePageFragment.Companion.logObserver
import kotlinx.android.synthetic.main.activity_main.*

class DataDisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("test print in data fragment!")
        if (logDao != null) {
            var allLogs = logDao!!.getAll()

        }
        return inflater.inflate(R.layout.data_display_fragment, container, false)
    }

}