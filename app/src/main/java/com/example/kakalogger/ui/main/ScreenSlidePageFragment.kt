package com.example.kakalogger.ui.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kakalogger.MainActivity
import com.example.kakalogger.MainActivity.LogDaoSetup.logDao
import com.example.kakalogger.R
import com.example.kakalogger.db.main.AppDatabase
import com.example.kakalogger.db.main.LogDao
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ScreenSlidePageFragment() : Fragment() {
    private lateinit var frag : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View = runBlocking {
        frag = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
        logDao = MainActivity.LogDaoSetup.logDao //get the logDao from MainActivity

        val button = frag.findViewById<Button>(R.id.button2)
        val bandInput = frag.findViewById<TextInputEditText>(R.id.bandInput)
        button.setOnClickListener {
            val newLog = com.example.kakalogger.db.main.Log(0, bandInput.text.toString(),
                "start time here", "end time here")
            launch {logDao?.insertAll(newLog)}
        }
        return@runBlocking frag
    }


}