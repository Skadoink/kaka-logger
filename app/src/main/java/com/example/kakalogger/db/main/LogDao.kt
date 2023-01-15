package com.example.kakalogger.db.main

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LogDao {
    @Query("SELECT * FROM log")
    fun getAll(): List<Log>

    @Query("SELECT * FROM log WHERE bands IN (:bandsArray)")
    fun loadAllByBands(bandsArray: Array<String>): List<Log>

    @Insert
    fun insertAll(vararg log: Log)

    @Delete
    fun delete(log: Log)

    //TODO: get most popular bands for smart suggestions at input
}