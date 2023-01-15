package com.example.kakalogger.ui.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kakalogger.R
import com.example.kakalogger.db.main.AppDatabase
import com.example.kakalogger.db.main.LogDao
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*

class ScreenSlidePageFragment(private val dao : LogDao) : Fragment() {
    private lateinit var frag : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        frag = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)

        val button = frag.findViewById<Button>(R.id.button2)
        val bandInput = frag.findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            val newLog = com.example.kakalogger.db.main.Log(bandInput.text.toString(), "start_time", "end_time")
            dao.insertAll(newLog)
        }

        return frag
    }


}