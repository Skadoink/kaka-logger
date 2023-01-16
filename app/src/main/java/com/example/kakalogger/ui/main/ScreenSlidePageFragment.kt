package com.example.kakalogger.ui.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.kakalogger.db.main.LogViewModel
import com.example.kakalogger.MainActivity.LogDaoSetup.logDao
import com.example.kakalogger.R
import com.example.kakalogger.db.main.Log
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ScreenSlidePageFragment() : Fragment() {
    private lateinit var frag : View
    private val model: LogViewModel by viewModels()
    companion object{
        lateinit var logObserver : Observer<List<Log>>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create the observer which updates the UI.
        logObserver = Observer<List<Log>> { logList ->
            // Update the UI, in this case, a TextView.
            logList.stream().forEach { log -> println(log.bands) }
        }
        println("test")
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.liveLogs.observe(this, logObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View = runBlocking {
        frag = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)

        val button = frag.findViewById<Button>(R.id.button2)
        val bandInput = frag.findViewById<TextInputEditText>(R.id.bandInput)
        button.setOnClickListener {
            val newLog = com.example.kakalogger.db.main.Log(0, bandInput.text.toString(),
                "start time here", "end time here")
            launch {logDao?.insertAll(newLog)}
        }
        return@runBlocking frag //return the fragment after the thread is done
    }


}