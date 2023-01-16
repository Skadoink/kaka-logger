package com.example.kakalogger.db.main

import androidx.lifecycle.LiveData
import com.example.kakalogger.MainActivity

class LogRepository() {
    private var mLogDao: LogDao = MainActivity.logDao!!
    private var mAllLogs: LiveData<List<Log>> = mLogDao.getAll()

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    fun getAllLogs(): LiveData<List<Log>> {
        return mAllLogs
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    suspend fun insert(log: Log) {
        mLogDao.insertAll(log)
    }
}
