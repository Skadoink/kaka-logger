package com.example.kakalogger.db.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogViewModel : ViewModel() {

    val liveLogs: MutableLiveData<List<Log>> by lazy {
        MutableLiveData<List<Log>>()
    } //this is the list of logs that will be displayed

    fun getAllLogs() : LiveData<List<Log>> {
        return liveLogs
    }

}